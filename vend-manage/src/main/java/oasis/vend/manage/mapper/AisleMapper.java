package oasis.vend.manage.mapper;

import java.util.List;

import oasis.vend.manage.domain.Aisle;

/**
 * Aisle InformationMapper接口
 * 
 * @author oasis
 * @date 2025-01-07
 */
public interface AisleMapper {
	/**
	 * 查询Aisle Information
	 * 
	 * @param id Aisle Information主键
	 * @return Aisle Information
	 */
	public Aisle selectAisleById(Long id);

	/**
	 * 查询Aisle Information列表
	 * 
	 * @param aisle Aisle Information
	 * @return Aisle Information集合
	 */
	public List<Aisle> selectAisleList(Aisle aisle);

	/**
	 * 新增Aisle Information
	 * 
	 * @param aisle Aisle Information
	 * @return 结果
	 */
	public int insertAisle(Aisle aisle);

	/**
	 * 修改Aisle Information
	 * 
	 * @param aisle Aisle Information
	 * @return 结果
	 */
	public int updateAisle(Aisle aisle);

	/**
	 * 删除Aisle Information
	 * 
	 * @param id Aisle Information主键
	 * @return 结果
	 */
	public int deleteAisleById(Long id);

	/**
	 * 批量删除Aisle Information
	 * 
	 * @param ids 需要删除的数据主键集合
	 * @return 结果
	 */
	public int deleteAisleByIds(Long[] ids);

	/**
	 * 批量新增Aisle Information
	 * 
	 * @param aisles Aisle Information列表
	 * @return 结果
	 */
	public void insertAisleBatch(List<Aisle> aisles);

	/**
	 * Goods IDで集計
	 * 
	 * @param ids
	 * @return
	 */
	public int countByGoodsId(Long[] ids);

}
