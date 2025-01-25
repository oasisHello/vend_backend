package oasis.vend.manage.service;

import java.util.List;
import oasis.vend.manage.domain.Order;
import oasis.vend.manage.domain.custom.OrderCustom;
import oasis.vend.manage.domain.dto.WorkOrderDto;

/**
 * Order tableService接口
 * 
 * @author oasis
 * @date 2025-01-20
 */
public interface IOrderService 
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
     * 批量删除Order table
     * 
     * @param ids 需要删除的Order table主键集合
     * @return 结果
     */
    public int deleteOrderByIds(Long[] ids);

    /**
     * 删除Order table信息
     * 
     * @param id Order table主键
     * @return 结果
     */
    public int deleteOrderById(Long id);

    /**
     * query OrderCustom
     *
     * @param order
     * @return
     */
    public List<OrderCustom> selectOrderCustomList(Order order);

    /**
     * Insert work order data transmission object
     * @param workOrder
     * @return
     */
    public int insertWorkOrder(WorkOrderDto workOrder);
}
