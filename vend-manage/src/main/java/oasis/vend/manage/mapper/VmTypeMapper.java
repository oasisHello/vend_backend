package oasis.vend.manage.mapper;

import java.util.List;
import oasis.vend.manage.domain.VmType;

/**
 * Vending Machine TypesMapper接口
 * 
 * @author oasis
 * @date 2025-01-04
 */
public interface VmTypeMapper 
{
    /**
     * 查询Vending Machine Types
     * 
     * @param id Vending Machine Types主键
     * @return Vending Machine Types
     */
    public VmType selectVmTypeById(Long id);

    /**
     * 查询Vending Machine Types列表
     * 
     * @param vmType Vending Machine Types
     * @return Vending Machine Types集合
     */
    public List<VmType> selectVmTypeList(VmType vmType);

    /**
     * 新增Vending Machine Types
     * 
     * @param vmType Vending Machine Types
     * @return 结果
     */
    public int insertVmType(VmType vmType);

    /**
     * 修改Vending Machine Types
     * 
     * @param vmType Vending Machine Types
     * @return 结果
     */
    public int updateVmType(VmType vmType);

    /**
     * 删除Vending Machine Types
     * 
     * @param id Vending Machine Types主键
     * @return 结果
     */
    public int deleteVmTypeById(Long id);

    /**
     * 批量删除Vending Machine Types
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteVmTypeByIds(Long[] ids);
}