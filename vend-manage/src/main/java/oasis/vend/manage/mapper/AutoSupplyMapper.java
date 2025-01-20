package oasis.vend.manage.mapper;

import java.util.List;
import oasis.vend.manage.domain.AutoSupply;

/**
 * auto supplyMapper接口
 * 
 * @author oasis
 * @date 2025-01-20
 */
public interface AutoSupplyMapper 
{
    /**
     * 查询auto supply
     * 
     * @param id auto supply主键
     * @return auto supply
     */
    public AutoSupply selectAutoSupplyById(Long id);

    /**
     * 查询auto supply列表
     * 
     * @param autoSupply auto supply
     * @return auto supply集合
     */
    public List<AutoSupply> selectAutoSupplyList(AutoSupply autoSupply);

    /**
     * 新增auto supply
     * 
     * @param autoSupply auto supply
     * @return 结果
     */
    public int insertAutoSupply(AutoSupply autoSupply);

    /**
     * 修改auto supply
     * 
     * @param autoSupply auto supply
     * @return 结果
     */
    public int updateAutoSupply(AutoSupply autoSupply);

    /**
     * 删除auto supply
     * 
     * @param id auto supply主键
     * @return 结果
     */
    public int deleteAutoSupplyById(Long id);

    /**
     * 批量删除auto supply
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAutoSupplyByIds(Long[] ids);
}
