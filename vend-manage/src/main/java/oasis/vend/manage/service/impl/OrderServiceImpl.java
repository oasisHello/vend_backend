package oasis.vend.manage.service.impl;

import java.util.Collections;
import java.util.List;
import oasis.vend.common.utils.DateUtils;
import oasis.vend.manage.domain.custom.OrderCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oasis.vend.manage.mapper.OrderMapper;
import oasis.vend.manage.domain.Order;
import oasis.vend.manage.service.IOrderService;

/**
 * Order tableService业务层处理
 * 
 * @author oasis
 * @date 2025-01-20
 */
@Service
public class OrderServiceImpl implements IOrderService
{
    @Autowired
    private OrderMapper orderMapper;

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
     * @param order Order table
     * @return 结果
     */
    @Override
    public int updateOrder(Order order)
    {
        order.setUpdateTime(DateUtils.getNowDate());
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
}
