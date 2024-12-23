package oasis.vend.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oasis.vend.manage.mapper.LocationMapper;
import oasis.vend.manage.domain.Location;
import oasis.vend.manage.service.ILocationService;

/**
 * locationService业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-23
 */
@Service
public class LocationServiceImpl implements ILocationService 
{
    @Autowired
    private LocationMapper locationMapper;

    /**
     * 查询location
     * 
     * @param id location主键
     * @return location
     */
    @Override
    public Location selectLocationById(Long id)
    {
        return locationMapper.selectLocationById(id);
    }

    /**
     * 查询location列表
     * 
     * @param location location
     * @return location
     */
    @Override
    public List<Location> selectLocationList(Location location)
    {
        return locationMapper.selectLocationList(location);
    }

    /**
     * 新增location
     * 
     * @param location location
     * @return 结果
     */
    @Override
    public int insertLocation(Location location)
    {
        return locationMapper.insertLocation(location);
    }

    /**
     * 修改location
     * 
     * @param location location
     * @return 结果
     */
    @Override
    public int updateLocation(Location location)
    {
        return locationMapper.updateLocation(location);
    }

    /**
     * 批量删除location
     * 
     * @param ids 需要删除的location主键
     * @return 结果
     */
    @Override
    public int deleteLocationByIds(Long[] ids)
    {
        return locationMapper.deleteLocationByIds(ids);
    }

    /**
     * 删除location信息
     * 
     * @param id location主键
     * @return 结果
     */
    @Override
    public int deleteLocationById(Long id)
    {
        return locationMapper.deleteLocationById(id);
    }
}
