package oasis.vend.manage.service.impl;

import java.util.List;

import oasis.vend.common.utils.DateUtils;
import oasis.vend.common.utils.uuid.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oasis.vend.manage.mapper.PolicyMapper;
import oasis.vend.manage.domain.Policy;
import oasis.vend.manage.service.IPolicyService;

/**
 * Policy InformationService业务层处理
 *
 * @author oasis
 * @date 2025-01-13
 */
@Service
public class PolicyServiceImpl implements IPolicyService {
    @Autowired
    private PolicyMapper policyMapper;

    /**
     * 查询Policy Information
     *
     * @param id Policy Information主键
     * @return Policy Information
     */
    @Override
    public Policy selectPolicyById(Long id) {
        return policyMapper.selectPolicyById(id);
    }

    /**
     * 查询Policy Information列表
     *
     * @param policy Policy Information
     * @return Policy Information
     */
    @Override
    public List<Policy> selectPolicyList(Policy policy) {
        return policyMapper.selectPolicyList(policy);
    }

    /**
     * 新增Policy Information
     *
     * @param policy Policy Information
     * @return 结果
     */
    @Override
    public int insertPolicy(Policy policy) {
        policy.setCreateTime(DateUtils.getNowDate());
        policy.setCode(UUIDUtils.getUUID());// autofill with 8-char string generated from an uuid.
        return policyMapper.insertPolicy(policy);
    }

    /**
     * 修改Policy Information
     *
     * @param policy Policy Information
     * @return 结果
     */
    @Override
    public int updatePolicy(Policy policy) {
        policy.setUpdateTime(DateUtils.getNowDate());
        return policyMapper.updatePolicy(policy);
    }

    /**
     * 批量删除Policy Information
     *
     * @param ids 需要删除的Policy Information主键
     * @return 结果
     */
    @Override
    public int deletePolicyByIds(Long[] ids) {
        return policyMapper.deletePolicyByIds(ids);
    }

    /**
     * 删除Policy Information信息
     *
     * @param id Policy Information主键
     * @return 结果
     */
    @Override
    public int deletePolicyById(Long id) {
        return policyMapper.deletePolicyById(id);
    }
}
