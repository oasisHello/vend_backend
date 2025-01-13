package oasis.vend.manage.mapper;

import java.util.List;
import oasis.vend.manage.domain.Policy;

/**
 * Policy InformationMapper接口
 * 
 * @author oasis
 * @date 2025-01-13
 */
public interface PolicyMapper 
{
    /**
     * 查询Policy Information
     * 
     * @param id Policy Information主键
     * @return Policy Information
     */
    public Policy selectPolicyById(Long id);

    /**
     * 查询Policy Information列表
     * 
     * @param policy Policy Information
     * @return Policy Information集合
     */
    public List<Policy> selectPolicyList(Policy policy);

    /**
     * 新增Policy Information
     * 
     * @param policy Policy Information
     * @return 结果
     */
    public int insertPolicy(Policy policy);

    /**
     * 修改Policy Information
     * 
     * @param policy Policy Information
     * @return 结果
     */
    public int updatePolicy(Policy policy);

    /**
     * 删除Policy Information
     * 
     * @param id Policy Information主键
     * @return 结果
     */
    public int deletePolicyById(Long id);

    /**
     * 批量删除Policy Information
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePolicyByIds(Long[] ids);
}
