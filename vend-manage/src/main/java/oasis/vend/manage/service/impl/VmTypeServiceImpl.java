package oasis.vend.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oasis.vend.manage.mapper.VmTypeMapper;
import oasis.vend.manage.domain.VmType;
import oasis.vend.manage.service.IVmTypeService;

/**
 * Machine TypesService业务层处理
 * 
 * @author oasis
 * @date 2025-01-07
 */
@Service
public class VmTypeServiceImpl implements IVmTypeService 
{
    @Autowired
    private VmTypeMapper vmTypeMapper;

    /**
     * 查询Machine Types
     * 
     * @param id Machine Types主键
     * @return Machine Types
     */
    @Override
    public VmType selectVmTypeById(Long id)
    {
        return vmTypeMapper.selectVmTypeById(id);
    }

    /**
     * 查询Machine Types列表
     * 
     * @param vmType Machine Types
     * @return Machine Types
     */
    @Override
    public List<VmType> selectVmTypeList(VmType vmType)
    {
        return vmTypeMapper.selectVmTypeList(vmType);
    }

    /**
     * 新增Machine Types
     * 
     * @param vmType Machine Types
     * @return 结果
     */
    @Override
    public int insertVmType(VmType vmType)
    {
        return vmTypeMapper.insertVmType(vmType);
    }

    /**
     * 修改Machine Types
     * 
     * @param vmType Machine Types
     * @return 结果
     */
    @Override
    public int updateVmType(VmType vmType)
    {
        return vmTypeMapper.updateVmType(vmType);
    }

    /**
     * 批量删除Machine Types
     * 
     * @param ids 需要删除的Machine Types主键
     * @return 结果
     */
    @Override
    public int deleteVmTypeByIds(Long[] ids)
    {
        return vmTypeMapper.deleteVmTypeByIds(ids);
    }

    /**
     * 删除Machine Types信息
     * 
     * @param id Machine Types主键
     * @return 结果
     */
    @Override
    public int deleteVmTypeById(Long id)
    {
        return vmTypeMapper.deleteVmTypeById(id);
    }
}
