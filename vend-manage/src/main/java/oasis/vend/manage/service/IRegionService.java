package oasis.vend.manage.service;

import java.util.List;
import oasis.vend.manage.domain.Region;
import oasis.vend.manage.domain.custom.RegionCustom;

/**
 * regionService接口
 * 
 * @author ruoyi
 * @date 2024-12-23
 */
public interface IRegionService 
{
    /**
     * 查询region
     * 
     * @param id region主键
     * @return region
     */
    public Region selectRegionById(Long id);

    /**
     * 查询region列表
     * 
     * @param region region
     * @return region集合
     */
    public List<Region> selectRegionList(Region region);

    /**
     * 新增region
     * 
     * @param region region
     * @return 结果
     */
    public int insertRegion(Region region);

    /**
     * 修改region
     * 
     * @param region region
     * @return 结果
     */
    public int updateRegion(Region region);

    /**
     * 批量删除region
     * 
     * @param ids 需要删除的region主键集合
     * @return 结果
     */
    public int deleteRegionByIds(Long[] ids);

    /**
     * 删除region信息
     * 
     * @param id region主键
     * @return 结果
     */
    public int deleteRegionById(Long id);
    
	/**
	 * 查询RegionCustom列表
	 * 
	 * @param region region
	 * @return regionCustom集合
	 */
    public List<RegionCustom> selectRegionCustomList(Region region);
}
