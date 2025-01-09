package oasis.vend.manage.service.impl;

import java.util.List;
import oasis.vend.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oasis.vend.manage.mapper.AisleMapper;
import oasis.vend.manage.domain.Aisle;
import oasis.vend.manage.service.IAisleService;

/**
 * Aisle InformationService业务层处理
 * 
 * @author oasis
 * @date 2025-01-07
 */
@Service
public class AisleServiceImpl implements IAisleService 
{
    @Autowired
    private AisleMapper aisleMapper;

    /**
     * 查询Aisle Information
     * 
     * @param id Aisle Information主键
     * @return Aisle Information
     */
    @Override
    public Aisle selectAisleById(Long id)
    {
        return aisleMapper.selectAisleById(id);
    }

    /**
     * 查询Aisle Information列表
     * 
     * @param aisle Aisle Information
     * @return Aisle Information
     */
    @Override
    public List<Aisle> selectAisleList(Aisle aisle)
    {
        return aisleMapper.selectAisleList(aisle);
    }

    /**
     * 新增Aisle Information
     * 
     * @param aisle Aisle Information
     * @return 结果
     */
    @Override
    public int insertAisle(Aisle aisle)
    {
        aisle.setCreateTime(DateUtils.getNowDate());
        return aisleMapper.insertAisle(aisle);
    }

    /**
     * 修改Aisle Information
     * 
     * @param aisle Aisle Information
     * @return 结果
     */
    @Override
    public int updateAisle(Aisle aisle)
    {
        aisle.setUpdateTime(DateUtils.getNowDate());
        return aisleMapper.updateAisle(aisle);
    }

    /**
     * 批量删除Aisle Information
     * 
     * @param ids 需要删除的Aisle Information主键
     * @return 结果
     */
    @Override
    public int deleteAisleByIds(Long[] ids)
    {
        return aisleMapper.deleteAisleByIds(ids);
    }

    /**
     * 删除Aisle Information信息
     * 
     * @param id Aisle Information主键
     * @return 结果
     */
    @Override
    public int deleteAisleById(Long id)
    {
        return aisleMapper.deleteAisleById(id);
    }
}
