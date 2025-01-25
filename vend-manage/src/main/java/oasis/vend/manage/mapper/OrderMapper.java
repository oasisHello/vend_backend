package oasis.vend.manage.mapper;

import java.util.List;
import oasis.vend.manage.domain.Order;
import oasis.vend.manage.domain.custom.OrderCustom;

/**
 * Order tableMapper接口
 * 
 * @author oasis
 * @date 2025-01-20
 */
public interface OrderMapper 
{
    /**
     * 查询Order table
     * 
     * @param id Order table主键
     * @return Order table
     */
    public Order selectOrderById(Long id);

    /**
     * 查询Order table列表
     * 
     * @param order Order table
     * @return Order table集合
     */
    public List<Order> selectOrderList(Order order);

    /**
     * 新增Order table
     * 
     * @param order Order table
     * @return 结果
     */
    public int insertOrder(Order order);

    /**
     * 修改Order table
     * 
     * @param order Order table
     * @return 结果
     */
    public int updateOrder(Order order);

    /**
     * 删除Order table
     * 
     * @param id Order table主键
     * @return 结果
     */
    public int deleteOrderById(Long id);

    /**
     * 批量删除Order table
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOrderByIds(Long[] ids);

    /**
     * query order custom list
     * @param order
     * @return
     */
    public List<OrderCustom> selectOrderCustomList(Order order);
}
