package oasis.vend.manage.mapper;

import java.util.List;
import oasis.vend.manage.domain.VmType;

/**
 * Machine TypesMapper接口
 * 
 * @author oasis
 * @date 2025-01-07
 */
public interface VmTypeMapper 
{
    /**
     * 查询Machine Types
     * 
     * @param id Machine Types主键
     * @return Machine Types
     */
    public VmType selectVmTypeById(Long id);

    /**
     * 查询Machine Types列表
     * 
     * @param vmType Machine Types
     * @return Machine Types集合
     */
    public List<VmType> selectVmTypeList(VmType vmType);

    /**
     * 新增Machine Types
     * 
     * @param vmType Machine Types
     * @return 结果
     */
    public int insertVmType(VmType vmType);

    /**
     * 修改Machine Types
     * 
     * @param vmType Machine Types
     * @return 结果
     */
    public int updateVmType(VmType vmType);

    /**
     * 删除Machine Types
     * 
     * @param id Machine Types主键
     * @return 结果
     */
    public int deleteVmTypeById(Long id);

    /**
     * 批量删除Machine Types
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteVmTypeByIds(Long[] ids);
}
