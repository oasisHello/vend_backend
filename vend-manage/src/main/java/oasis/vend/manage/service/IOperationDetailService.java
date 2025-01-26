package oasis.vend.manage.service;

import java.util.List;
import oasis.vend.manage.domain.OperationDetail;

/**
 * Operation detail tableService接口
 * 
 * @author oasis
 * @date 2025-01-20
 */
public interface IOperationDetailService 
{
    /**
     * 查询Operation detail table
     * 
     * @param id Operation detail table主键
     * @return Operation detail table
     */
    public OperationDetail selectOperationDetailById(Long id);

    /**
     * 查询Operation detail table列表
     * 
     * @param operationDetail Operation detail table
     * @return Operation detail table集合
     */
    public List<OperationDetail> selectOperationDetailList(OperationDetail operationDetail);

    /**
     * 新增Operation detail table
     * 
     * @param operationDetail Operation detail table
     * @return 结果
     */
    public int insertOperationDetail(OperationDetail operationDetail);

    /**
     * 修改Operation detail table
     * 
     * @param operationDetail Operation detail table
     * @return 结果
     */
    public int updateOperationDetail(OperationDetail operationDetail);

    /**
     * 批量删除Operation detail table
     * 
     * @param ids 需要删除的Operation detail table主键集合
     * @return 结果
     */
    public int deleteOperationDetailByIds(Long[] ids);

    /**
     * 删除Operation detail table信息
     * 
     * @param id Operation detail table主键
     * @return 结果
     */
    public int deleteOperationDetailById(Long id);

    /**
     * batch insert operation detail
     * @param details
     * @return
     */
     public int batchInsertOperationDetail(List<OperationDetail> details);

    /**
     * delete the operation detail by order id
     * @param orderId
     * @return
     */
     public int deleteOperationDetailByOrderId(Long orderId);

    /**
     * select OperationDetail By Order Id
     * @param orderId
     * @return
     */
     public List<OperationDetail> selectOperationDetailByOrderId(Long orderId);
}
