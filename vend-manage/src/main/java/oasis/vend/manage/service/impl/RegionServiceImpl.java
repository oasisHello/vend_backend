package oasis.vend.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oasis.vend.manage.mapper.RegionMapper;
import oasis.vend.manage.domain.Region;
import oasis.vend.manage.domain.custom.RegionCustom;
import oasis.vend.manage.service.IRegionService;

/**
 * regionService业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-23
 */
@Service
public class RegionServiceImpl implements IRegionService {
	@Autowired
	private RegionMapper regionMapper;

	/**
	 * 查询region
	 * 
	 * @param id region主键
	 * @return region
	 */
	@Override
	public Region selectRegionById(Long id) {
		return regionMapper.selectRegionById(id);
	}

	/**
	 * 查询region列表
	 * 
	 * @param region region
	 * @return region
	 */
	@Override
	public List<Region> selectRegionList(Region region) {
		return regionMapper.selectRegionList(region);
	}

	/**
	 * 新增region
	 * 
	 * @param region region
	 * @return 结果
	 */
	@Override
	public int insertRegion(Region region) {
		return regionMapper.insertRegion(region);
	}

	/**
	 * 修改region
	 * 
	 * @param region region
	 * @return 结果
	 */
	@Override
	public int updateRegion(Region region) {
		return regionMapper.updateRegion(region);
	}

	/**
	 * 批量删除region
	 * 
	 * @param ids 需要删除的region主键
	 * @return 结果
	 */
	@Override
	public int deleteRegionByIds(Long[] ids) {
		return regionMapper.deleteRegionByIds(ids);
	}

	/**
	 * 删除region信息
	 * 
	 * @param id region主键
	 * @return 结果
	 */
	@Override
	public int deleteRegionById(Long id) {
		return regionMapper.deleteRegionById(id);
	}

	@Override
	public List<RegionCustom> selectRegionCustomList(Region region) {
		return regionMapper.selectRegionCustomList(region);
	}

}
