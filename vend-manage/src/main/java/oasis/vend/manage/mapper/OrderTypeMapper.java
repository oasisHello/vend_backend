package oasis.vend.manage.mapper;

import java.util.List;
import oasis.vend.manage.domain.OrderType;

/**
 * Order type tableMapper接口
 * 
 * @author oasis
 * @date 2025-01-20
 */
public interface OrderTypeMapper 
{
    /**
     * 查询Order type table
     * 
     * @param id Order type table主键
     * @return Order type table
     */
    public OrderType selectOrderTypeById(Long id);

    /**
     * 查询Order type table列表
     * 
     * @param orderType Order type table
     * @return Order type table集合
     */
    public List<OrderType> selectOrderTypeList(OrderType orderType);

    /**
     * 新增Order type table
     * 
     * @param orderType Order type table
     * @return 结果
     */
    public int insertOrderType(OrderType orderType);

    /**
     * 修改Order type table
     * 
     * @param orderType Order type table
     * @return 结果
     */
    public int updateOrderType(OrderType orderType);

    /**
     * 删除Order type table
     * 
     * @param id Order type table主键
     * @return 结果
     */
    public int deleteOrderTypeById(Long id);

    /**
     * 批量删除Order type table
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOrderTypeByIds(Long[] ids);
}
