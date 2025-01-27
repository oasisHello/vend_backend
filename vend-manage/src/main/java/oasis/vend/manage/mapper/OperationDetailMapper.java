package oasis.vend.manage.mapper;

import java.util.List;
import oasis.vend.manage.domain.OperationDetail;
import oasis.vend.manage.domain.dto.WorkOrderDto;

/**
 * Operation detail tableMapper接口
 * 
 * @author oasis
 * @date 2025-01-20
 */
public interface OperationDetailMapper 
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
     * update operation detail in a batch way.
     * @param OperationDetailList
     * @return
     */
    public int batchUpdateOperationDetail(List<OperationDetail> OperationDetailList);

    /**
     * 删除Operation detail table
     * 
     * @param id Operation detail table主键
     * @return 结果
     */
    public int deleteOperationDetailById(Long id);

    /**
     * 批量删除Operation detail table
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOperationDetailByIds(Long[] ids);

    /**
     * batch insert operation details
     * @param details
     * @return
     */
    public int batchInsertOperationDetail(List<OperationDetail> details);

    /**
     * delete operation detail by order id
     * @return
     */
    public int deleteOperationDetailByOrderId();

    /**
     * select operation details by order id
     * @param orderId
     * @return
     */
    List<OperationDetail> selectOperationDetailsByOrderId(Long orderId);
}
