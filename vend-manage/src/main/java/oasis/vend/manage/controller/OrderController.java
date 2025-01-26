package oasis.vend.manage.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.core.bean.BeanUtil;
import oasis.vend.manage.domain.OperationDetail;
import oasis.vend.manage.domain.custom.OrderCustom;
import oasis.vend.manage.domain.dto.OperationDetailDto;
import oasis.vend.manage.domain.dto.WorkOrderDto;
import oasis.vend.manage.service.IOperationDetailService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import oasis.vend.common.annotation.Log;
import oasis.vend.common.core.controller.BaseController;
import oasis.vend.common.core.domain.AjaxResult;
import oasis.vend.common.enums.BusinessType;
import oasis.vend.manage.domain.Order;
import oasis.vend.manage.service.IOrderService;
import oasis.vend.common.utils.poi.ExcelUtil;
import oasis.vend.common.core.page.TableDataInfo;

/**
 * Order tableController
 * 
 * @author oasis
 * @date 2025-01-20
 */
@RestController
@RequestMapping("/manage/order")
public class OrderController extends BaseController
{
    @Autowired
    private IOrderService orderService;
    @Autowired
    IOperationDetailService operationDetailService;

    /**
     * 查询Order table列表
     */
    @PreAuthorize("@ss.hasPermi('manage:order:list')")
    @GetMapping("/list")
    public TableDataInfo list(Order order)
    {
        startPage();
        List<OrderCustom> list = orderService.selectOrderCustomList(order);// query the orderCustom
        return getDataTable(list);
    }

    /**
     * 导出Order table列表
     */
    @PreAuthorize("@ss.hasPermi('manage:order:export')")
    @Log(title = "Order table", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Order order)
    {
        List<Order> list = orderService.selectOrderList(order);
        ExcelUtil<Order> util = new ExcelUtil<Order>(Order.class);
        util.exportExcel(response, list, "Order table数据");
    }

    /**
     * 获取Order table详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:order:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(orderService.selectOrderById(id));
    }

    /**
     * 新增Order table
     */
    @PreAuthorize("@ss.hasPermi('manage:order:add')")
    @Log(title = "Order table", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WorkOrderDto workOrderDto)
    {
        return toAjax(orderService.insertWorkOrder(workOrderDto));
    }

    /**
     * 修改Order table
     */
    @PreAuthorize("@ss.hasPermi('manage:order:edit')")
    @Log(title = "Order table", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WorkOrderDto order)
    {
        return toAjax(orderService.updateOrder(order));
    }

    /**
     * 删除Order table
     */
    @PreAuthorize("@ss.hasPermi('manage:order:remove')")
    @Log(title = "Order table", businessType = BusinessType.DELETE)
	@DeleteMapping("/batch/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(orderService.deleteOrderByIds(ids));
    }

    /**
     * 删除Order table
     */
    @PreAuthorize("@ss.hasPermi('manage:order:remove')")
    @Log(title = "Order table", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    @Transactional
    public AjaxResult remove(@PathVariable Long id) {
        operationDetailService.deleteOperationDetailByOrderId(id);
        return toAjax(orderService.deleteOrderById(id));
    }

    /**
     * 获取Order table详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:order:query')")
    @GetMapping(value = "/operation/{id}")
    public AjaxResult getOperationOrderWithDetail(@PathVariable("id") Long id) {
        WorkOrderDto operationOrderDto = new WorkOrderDto();
        //1. get operation details by order id
        List<OperationDetail> operationDetails = operationDetailService.selectOperationDetailByOrderId(id);
        //2. get order
        Order order = orderService.selectOrderById(id);

        operationOrderDto = BeanUtil.copyProperties(order, WorkOrderDto.class);
        List<OperationDetailDto> dtoList = operationDetails.stream().map(detail -> {
            return BeanUtil.copyProperties(detail, OperationDetailDto.class);
        }).collect(Collectors.toList());
        operationOrderDto.setDetails(dtoList);
        return success(operationOrderDto);
    }
}
