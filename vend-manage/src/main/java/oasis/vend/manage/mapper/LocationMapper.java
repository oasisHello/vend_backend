package oasis.vend.manage.mapper;

import java.util.List;
import oasis.vend.manage.domain.Location;

/**
 * locationMapper接口
 * 
 * @author ruoyi
 * @date 2024-12-23
 */
public interface LocationMapper 
{
    /**
     * 查询location
     * 
     * @param id location主键
     * @return location
     */
    public Location selectLocationById(Long id);

    /**
     * 查询location列表
     * 
     * @param location location
     * @return location集合
     */
    public List<Location> selectLocationList(Location location);

    /**
     * 新增location
     * 
     * @param location location
     * @return 结果
     */
    public int insertLocation(Location location);

    /**
     * 修改location
     * 
     * @param location location
     * @return 结果
     */
    public int updateLocation(Location location);

    /**
     * 删除location
     * 
     * @param id location主键
     * @return 结果
     */
    public int deleteLocationById(Long id);

    /**
     * 批量删除location
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLocationByIds(Long[] ids);
}
