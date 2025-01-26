package oasis.vend.manage.service.impl;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import oasis.vend.common.constant.VM;
import oasis.vend.common.exception.ServiceException;
import oasis.vend.common.utils.DateUtils;
import oasis.vend.common.utils.StringUtils;
import oasis.vend.common.utils.uuid.UUIDUtils;
import oasis.vend.manage.domain.OperationDetail;
import oasis.vend.manage.domain.VendingMachine;
import oasis.vend.manage.domain.custom.OrderCustom;
import oasis.vend.manage.domain.dto.OperationDetailDto;
import oasis.vend.manage.domain.dto.WorkOrderDto;
import oasis.vend.manage.mapper.VendingMachineMapper;
import oasis.vend.manage.service.IOperationDetailService;
import oasis.vend.manage.service.IVendingMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import oasis.vend.manage.mapper.OrderMapper;
import oasis.vend.manage.domain.Order;
import oasis.vend.manage.service.IOrderService;
import org.springframework.transaction.annotation.Transactional;
import software.amazon.awssdk.services.s3.endpoints.internal.Value;

import static oasis.vend.common.constant.VM.*;

/**
 * Order tableService业务层处理
 *
 * @author oasis
 * @date 2025-01-20
 */
@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private IVendingMachineService vmService;
    @Autowired
    private IOperationDetailService operationDetailService;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 查询Order table
     *
     * @param id Order table主键
     * @return Order table
     */
    @Override
    public Order selectOrderById(Long id)
    {
        return orderMapper.selectOrderById(id);
    }

    /**
     * 查询Order table列表
     *
     * @param order Order table
     * @return Order table
     */
    @Override
    public List<Order> selectOrderList(Order order)
    {
        return orderMapper.selectOrderList(order);
    }

    /**
     * 新增Order table
     *
     * @param order Order table
     * @return 结果
     */
    @Override
    public int insertOrder(Order order)
    {
        order.setCreateTime(DateUtils.getNowDate());
        return orderMapper.insertOrder(order);
    }

    /**
     * 修改Order table
     *
     * @param workOrderDto Order table
     * @return 结果
     */
    @Override
    public int updateOrder(WorkOrderDto workOrderDto) {
        // dto->domain
        // workOrderDto -> order
        Order order = BeanUtil.copyProperties(workOrderDto, Order.class);
        // 4.Only Operation Order
        // OperationDetailDto -> Operation
        if (workOrderDto.getCreateType() == ORDER_OPERATOR) {
            List<OperationDetailDto> detailDtos = workOrderDto.getDetails();

            // Check not null
            if (detailDtos != null && !detailDtos.isEmpty()) {
                List<OperationDetail> detailList = detailDtos.stream().map(dto -> {
                    return BeanUtil.copyProperties(dto, OperationDetail.class);
                }).collect(Collectors.toList());
                operationDetailService.batchInsertOperationDetail(detailList);

            } else {
                throw new ServiceException("Supply detail is empty!");
            }
        }

        return orderMapper.updateOrder(order);
    }

    /**
     * 批量删除Order table
     *
     * @param ids 需要删除的Order table主键
     * @return 结果
     */
    @Override
    public int deleteOrderByIds(Long[] ids)
    {
        return orderMapper.deleteOrderByIds(ids);
    }

    /**
     * 删除Order table信息
     *
     * @param id Order table主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteOrderById(Long id)
    {
        return orderMapper.deleteOrderById(id);
    }

    /**
     * @param order
     * @return
     */
    @Override
    public List<OrderCustom> selectOrderCustomList(Order order) {
        return orderMapper.selectOrderCustomList(order);
    }

    /**
     * @param workOrder
     * @return
     */
    @Transactional
    @Override
    public int insertWorkOrder(WorkOrderDto workOrder) {
        //1.order type & machine state validation
        //1.1 obtain machine
        VendingMachine vm = vmService.selectVendingMachineByInnerCode(workOrder.getVmInnerCode());
        //1.2 validation
        validateOrderAndVm(workOrder, vm);

        //2. Order Assembly
        Order order = new Order();
        order.setStatus(ORDER_STATUS_ACCEPTED);
        order.setVmInnerCode(vm.getInnerCode());
        order.setTypeId(workOrder.getTypeId());

        // 2.Same order?(by status,vmInnerCode, typeId)
        //2.2 call mapper
        List<Order> any = orderMapper.selectOrderList(order);
        //2.3 if any is not null
        if (any != null && !any.isEmpty()) {
            throw new ServiceException("Same order already exists!");
        }

        order.setUserId(workOrder.getUserId());
        order.setAssignorId(workOrder.getAssignorId());
        order.setDescription(workOrder.getDescription());
        order.setIsAutoGenerated(GENERATION_MANUAL);
        order.setRegionId(vm.getRegionId());
        order.setCreateTime(DateUtils.getNowDate());
        order.setCode(UUIDUtils.getUUID());// NOTE:temporally
        order.setStatus(ORDER_STATUS_PEND);
        // generate work order code(e.g.,202501250001)
        order.setCode(generateOrderCode());
        // 3. save this order
        int i = orderMapper.insertOrder(order);

        // 4.Only Operation Order
        if (workOrder.getCreateType() == ORDER_OPERATOR) {
            List<OperationDetailDto> detailDtos = workOrder.getDetails();

            // Check not null
            if (detailDtos != null && !detailDtos.isEmpty()) {
                List<OperationDetail> detailList = detailDtos.stream().map(dto -> {
                    OperationDetail detail = BeanUtil.copyProperties(dto, OperationDetail.class);
                    detail.setOrderId(order.getId());// set the order id
                    return detail;
                }).collect(Collectors.toList());
                operationDetailService.batchInsertOperationDetail(detailList);

            } else {
                throw new ServiceException("Supply detail is empty!");
            }
        }
        return i; //NOTSURE: what it should return?
    }

    private static void validateOrderAndVm(WorkOrderDto workOrder, VendingMachine vendingMachine) {
        Long vmStatus = vendingMachine.getVmStatus();
        Long orderTypeId = workOrder.getTypeId();

        // Exception prefix for consistent error messages
        final String EXCEPTION_PREFIX = "Validation Error: ";

        // Validate installation orders
        if (Objects.equals(vmStatus, STATUS_DEPLOYED) && orderTypeId == ORDER_INSTALLATION) {
            throw new ServiceException(EXCEPTION_PREFIX + "An installation order cannot be created because the vending machine is already deployed.");
        }

        // Validate supply orders
        if (isVmUndeployed(vmStatus) && orderTypeId == ORDER_SUPPLY) {
            throw new ServiceException(EXCEPTION_PREFIX + "A supply order cannot be created because the vending machine is not yet deployed.");
        }

        // Validate repair orders
        if (isVmUndeployed(vmStatus) && orderTypeId == ORDER_REPAIR) {
            throw new ServiceException(EXCEPTION_PREFIX + "A repair order cannot be created because the vending machine is not yet deployed.");
        }

        // Validate collection orders
        if (isVmUndeployed(vmStatus) && orderTypeId == ORDER_COLLECTION) {
            throw new ServiceException(EXCEPTION_PREFIX + "A collection order cannot be created because the vending machine is not yet deployed.");
        }
    }

    private static boolean isVmUndeployed(Long vmStatus) {
        return Objects.equals(vmStatus, STATUS_UNDEPLOY);
    }

    private String generateOrderCode() {
        // Current datatime:yyyyMMdd
        String dateStr = DateUtils.getDate().replaceAll("-", "");
        //2.generate redis key by data
        String redisKey = "oasis.vend.manage.order" + dateStr;
        // redis key exists,
        if (!redisTemplate.hasKey(redisKey)) {
            redisTemplate.opsForValue().set(redisKey, 1, Duration.ofDays(1));
            return dateStr + "0001";
        }
        // redis key not exists
        return dateStr + StrUtil.padPre(redisTemplate.opsForValue().increment(redisKey).toString(), 4, '0');
    }
}
