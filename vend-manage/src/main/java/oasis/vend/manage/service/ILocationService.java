package oasis.vend.manage.service;

import java.util.List;

import oasis.vend.manage.domain.Location;
import oasis.vend.manage.domain.custom.LocationCustom;

/**
 * locationService接口
 * 
 * @author ruoyi
 * @date 2024-12-23
 */
public interface ILocationService {
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
	 * 批量删除location
	 * 
	 * @param ids 需要删除的location主键集合
	 * @return 结果
	 */
	public int deleteLocationByIds(Long[] ids);

	/**
	 * 删除location信息
	 * 
	 * @param id location主键
	 * @return 结果
	 */
	public int deleteLocationById(Long id);

	/**
	 * query locationCustom list
	 */
	public List<LocationCustom> selectLocationCustomns(Location location);
}
