package oasis.vend.manage.service.impl;

import oasis.vend.common.utils.DateUtils;
import oasis.vend.manage.domain.OperationDetail;
import oasis.vend.manage.mapper.OperationDetailMapper;
import oasis.vend.manage.service.IOperationDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Operation detail tableService业务层处理
 *
 * @author oasis
 * @date 2025-01-20
 */
@Service
public class OperationDetailServiceImpl implements IOperationDetailService {
    @Autowired
    private OperationDetailMapper operationDetailMapper;

    /**
     * 查询Operation detail table
     *
     * @param id Operation detail table主键
     * @return Operation detail table
     */
    @Override
    public OperationDetail selectOperationDetailById(Long id) {
        return operationDetailMapper.selectOperationDetailById(id);
    }

    /**
     * 查询Operation detail table列表
     *
     * @param operationDetail Operation detail table
     * @return Operation detail table
     */
    @Override
    public List<OperationDetail> selectOperationDetailList(OperationDetail operationDetail) {
        return operationDetailMapper.selectOperationDetailList(operationDetail);
    }

    /**
     * 新增Operation detail table
     *
     * @param operationDetail Operation detail table
     * @return 结果
     */
    @Override
    public int insertOperationDetail(OperationDetail operationDetail) {
        operationDetail.setCreateTime(DateUtils.getNowDate());
        return operationDetailMapper.insertOperationDetail(operationDetail);
    }

    /**
     * 修改Operation detail table
     *
     * @param operationDetail Operation detail table
     * @return 结果
     */
    @Override
    public int updateOperationDetail(OperationDetail operationDetail) {
        operationDetail.setUpdateTime(DateUtils.getNowDate());
        return operationDetailMapper.updateOperationDetail(operationDetail);
    }

    /**
     * 批量删除Operation detail table
     *
     * @param ids 需要删除的Operation detail table主键
     * @return 结果
     */
    @Override
    public int deleteOperationDetailByIds(Long[] ids) {
        return operationDetailMapper.deleteOperationDetailByIds(ids);
    }

    /**
     * 删除Operation detail table信息
     *
     * @param id Operation detail table主键
     * @return 结果
     */
    @Override
    public int deleteOperationDetailById(Long id) {
        return operationDetailMapper.deleteOperationDetailById(id);
    }

    /**
     * @param details
     * @return
     */
    @Override
    public int batchInsertOperationDetail(List<OperationDetail> details) {
        return operationDetailMapper.batchInsertOperationDetail(details);
    }

/**
 *
 */

    /**
     * delete operation detail by order
     *
     * @param orderId
     * @return
     */
    @Override
    public int deleteOperationDetailByOrderId(Long orderId) {
        return operationDetailMapper.deleteOperationDetailByOrderId();
    }

    /**
     * select operation details by order id
     *
     * @param orderId
     * @return
     */
    @Override
    public List<OperationDetail> selectOperationDetailByOrderId(Long orderId) {
        return operationDetailMapper.selectOperationDetailsByOrderId(orderId);
    }

    /**
     * @param operationDetails
     * @return
     */
    @Override
    public int batchUpdateOperationDetail(List<OperationDetail> operationDetails) {
        int count = 0;
        for (OperationDetail detail : operationDetails) {
            operationDetailMapper.updateOperationDetail(detail);
            count++;
        }
        return count;
    }
}
