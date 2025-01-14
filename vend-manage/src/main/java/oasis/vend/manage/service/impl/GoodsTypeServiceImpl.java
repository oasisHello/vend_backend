package oasis.vend.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oasis.vend.common.utils.DateUtils;
import oasis.vend.common.utils.uuid.UUIDUtils;
import oasis.vend.manage.domain.GoodsType;
import oasis.vend.manage.mapper.GoodsTypeMapper;
import oasis.vend.manage.service.IGoodsTypeService;

/**
 * Product type tableService业务层处理
 * 
 * @author oasis
 * @date 2025-01-14
 */
@Service
public class GoodsTypeServiceImpl implements IGoodsTypeService {
	@Autowired
	private GoodsTypeMapper goodsTypeMapper;

	/**
	 * 查询Product type table
	 * 
	 * @param id Product type table主键
	 * @return Product type table
	 */
	@Override
	public GoodsType selectGoodsTypeById(Long id) {
		return goodsTypeMapper.selectGoodsTypeById(id);
	}

	/**
	 * 查询Product type table列表
	 * 
	 * @param goodsType Product type table
	 * @return Product type table
	 */
	@Override
	public List<GoodsType> selectGoodsTypeList(GoodsType goodsType) {
		return goodsTypeMapper.selectGoodsTypeList(goodsType);
	}

	/**
	 * 新增Product type table
	 * 
	 * @param goodsType Product type table
	 * @return 结果
	 */
	@Override
	public int insertGoodsType(GoodsType goodsType) {
		goodsType.setCreateTime(DateUtils.getNowDate());
		goodsType.setCode(UUIDUtils.getUUID());// auto fill code with 8-char from uuid.
		return goodsTypeMapper.insertGoodsType(goodsType);
	}

	/**
	 * 修改Product type table
	 * 
	 * @param goodsType Product type table
	 * @return 结果
	 */
	@Override
	public int updateGoodsType(GoodsType goodsType) {
		goodsType.setUpdateTime(DateUtils.getNowDate());
		return goodsTypeMapper.updateGoodsType(goodsType);
	}

	/**
	 * 批量删除Product type table
	 * 
	 * @param ids 需要删除的Product type table主键
	 * @return 结果
	 */
	@Override
	public int deleteGoodsTypeByIds(Long[] ids) {
		return goodsTypeMapper.deleteGoodsTypeByIds(ids);
	}

	/**
	 * 删除Product type table信息
	 * 
	 * @param id Product type table主键
	 * @return 结果
	 */
	@Override
	public int deleteGoodsTypeById(Long id) {
		return goodsTypeMapper.deleteGoodsTypeById(id);
	}
}
