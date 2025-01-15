package oasis.vend.manage.service.impl;

import java.util.List;

import oasis.vend.common.exception.ServiceException;
import oasis.vend.manage.mapper.AisleMapper;
import oasis.vend.manage.service.IAisleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Service;

import oasis.vend.common.utils.DateUtils;
import oasis.vend.common.utils.uuid.UUIDUtils;
import oasis.vend.manage.domain.Goods;
import oasis.vend.manage.mapper.GoodsMapper;
import oasis.vend.manage.service.IGoodsService;

/**
 * Product tableService业务层处理
 * 
 * @author oasis
 * @date 2025-01-14
 */
@Service
public class GoodsServiceImpl implements IGoodsService {
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private IAisleService aisleService;

	/**
	 * 查询Product table
	 * 
	 * @param id Product table主键
	 * @return Product table
	 */
	@Override
	public Goods selectGoodsById(Long id) {
		return goodsMapper.selectGoodsById(id);
	}

	/**
	 * 查询Product table列表
	 * 
	 * @param goods Product table
	 * @return Product table
	 */
	@Override
	public List<Goods> selectGoodsList(Goods goods) {
		return goodsMapper.selectGoodsList(goods);
	}

	/**
	 * 新增Product table
	 * 
	 * @param goods Product table
	 * @return 结果
	 */
	@Override
	public int insertGoods(Goods goods) {
		goods.setCreateTime(DateUtils.getNowDate());
		goods.setCode(UUIDUtils.getUUID());// auto fill with 8-char generated from uuid
		return goodsMapper.insertGoods(goods);
	}

	/**
	 * 修改Product table
	 * 
	 * @param goods Product table
	 * @return 结果
	 */
	@Override
	public int updateGoods(Goods goods) {
		goods.setUpdateTime(DateUtils.getNowDate());
		return goodsMapper.updateGoods(goods);
	}

	/**
	 * 批量删除Product table
	 * 
	 * @param ids 需要删除的Product table主键
	 * @return 结果
	 */
	@Override
	public int deleteGoodsByIds(Long[] ids) {
		// check if this goods exists in aisle or not
		int count = aisleService.countByGoodsId(ids);
		if (count > 0) {
			throw new ServiceException("Deletion failed: The item is currently associated with an existing aisle.");//削除に失敗した:対象は現在既存の通路に関連付けられています.
		} else {
			return goodsMapper.deleteGoodsByIds(ids);// if not execute deletion
		}
	}

	/**
	 * 删除Product table信息
	 * 
	 * @param id Product table主键
	 * @return 结果
	 */
	@Override
	public int deleteGoodsById(Long id) {
		return goodsMapper.deleteGoodsById(id);
	}
}
