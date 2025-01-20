package oasis.vend.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oasis.vend.manage.mapper.AutoSupplyMapper;
import oasis.vend.manage.domain.AutoSupply;
import oasis.vend.manage.service.IAutoSupplyService;

/**
 * auto supplyService业务层处理
 * 
 * @author oasis
 * @date 2025-01-20
 */
@Service
public class AutoSupplyServiceImpl implements IAutoSupplyService 
{
    @Autowired
    private AutoSupplyMapper autoSupplyMapper;

    /**
     * 查询auto supply
     * 
     * @param id auto supply主键
     * @return auto supply
     */
    @Override
    public AutoSupply selectAutoSupplyById(Long id)
    {
        return autoSupplyMapper.selectAutoSupplyById(id);
    }

    /**
     * 查询auto supply列表
     * 
     * @param autoSupply auto supply
     * @return auto supply
     */
    @Override
    public List<AutoSupply> selectAutoSupplyList(AutoSupply autoSupply)
    {
        return autoSupplyMapper.selectAutoSupplyList(autoSupply);
    }

    /**
     * 新增auto supply
     * 
     * @param autoSupply auto supply
     * @return 结果
     */
    @Override
    public int insertAutoSupply(AutoSupply autoSupply)
    {
        return autoSupplyMapper.insertAutoSupply(autoSupply);
    }

    /**
     * 修改auto supply
     * 
     * @param autoSupply auto supply
     * @return 结果
     */
    @Override
    public int updateAutoSupply(AutoSupply autoSupply)
    {
        return autoSupplyMapper.updateAutoSupply(autoSupply);
    }

    /**
     * 批量删除auto supply
     * 
     * @param ids 需要删除的auto supply主键
     * @return 结果
     */
    @Override
    public int deleteAutoSupplyByIds(Long[] ids)
    {
        return autoSupplyMapper.deleteAutoSupplyByIds(ids);
    }

    /**
     * 删除auto supply信息
     * 
     * @param id auto supply主键
     * @return 结果
     */
    @Override
    public int deleteAutoSupplyById(Long id)
    {
        return autoSupplyMapper.deleteAutoSupplyById(id);
    }
}
