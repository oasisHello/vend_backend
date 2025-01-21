package oasis.vend.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oasis.vend.manage.mapper.OrderTypeMapper;
import oasis.vend.manage.domain.OrderType;
import oasis.vend.manage.service.IOrderTypeService;

/**
 * Order type tableService业务层处理
 * 
 * @author oasis
 * @date 2025-01-20
 */
@Service
public class OrderTypeServiceImpl implements IOrderTypeService 
{
    @Autowired
    private OrderTypeMapper orderTypeMapper;

    /**
     * 查询Order type table
     * 
     * @param id Order type table主键
     * @return Order type table
     */
    @Override
    public OrderType selectOrderTypeById(Long id)
    {
        return orderTypeMapper.selectOrderTypeById(id);
    }

    /**
     * 查询Order type table列表
     * 
     * @param orderType Order type table
     * @return Order type table
     */
    @Override
    public List<OrderType> selectOrderTypeList(OrderType orderType)
    {
        return orderTypeMapper.selectOrderTypeList(orderType);
    }

    /**
     * 新增Order type table
     * 
     * @param orderType Order type table
     * @return 结果
     */
    @Override
    public int insertOrderType(OrderType orderType)
    {
        return orderTypeMapper.insertOrderType(orderType);
    }

    /**
     * 修改Order type table
     * 
     * @param orderType Order type table
     * @return 结果
     */
    @Override
    public int updateOrderType(OrderType orderType)
    {
        return orderTypeMapper.updateOrderType(orderType);
    }

    /**
     * 批量删除Order type table
     * 
     * @param ids 需要删除的Order type table主键
     * @return 结果
     */
    @Override
    public int deleteOrderTypeByIds(Long[] ids)
    {
        return orderTypeMapper.deleteOrderTypeByIds(ids);
    }

    /**
     * 删除Order type table信息
     * 
     * @param id Order type table主键
     * @return 结果
     */
    @Override
    public int deleteOrderTypeById(Long id)
    {
        return orderTypeMapper.deleteOrderTypeById(id);
    }
}
