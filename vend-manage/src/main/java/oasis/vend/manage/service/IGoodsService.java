package oasis.vend.manage.service;

import java.util.List;
import oasis.vend.manage.domain.Goods;

/**
 * Product tableService接口
 * 
 * @author oasis
 * @date 2025-01-14
 */
public interface IGoodsService 
{
    /**
     * 查询Product table
     * 
     * @param id Product table主键
     * @return Product table
     */
    public Goods selectGoodsById(Long id);

    /**
     * 查询Product table列表
     * 
     * @param goods Product table
     * @return Product table集合
     */
    public List<Goods> selectGoodsList(Goods goods);

    /**
     * 新增Product table
     * 
     * @param goods Product table
     * @return 结果
     */
    public int insertGoods(Goods goods);

    /**
     * 修改Product table
     * 
     * @param goods Product table
     * @return 结果
     */
    public int updateGoods(Goods goods);

    /**
     * 批量删除Product table
     * 
     * @param ids 需要删除的Product table主键集合
     * @return 结果
     */
    public int deleteGoodsByIds(Long[] ids);

    /**
     * 删除Product table信息
     * 
     * @param id Product table主键
     * @return 结果
     */
    public int deleteGoodsById(Long id);

    /**
     * insert multi goods
     * @param goodsList
     * @return
     */
    public int batchInsert(List<Goods> goodsList);
}
