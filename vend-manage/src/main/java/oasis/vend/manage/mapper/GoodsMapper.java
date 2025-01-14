package oasis.vend.manage.mapper;

import java.util.List;
import oasis.vend.manage.domain.Goods;

/**
 * Product tableMapper接口
 * 
 * @author oasis
 * @date 2025-01-14
 */
public interface GoodsMapper 
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
     * 删除Product table
     * 
     * @param id Product table主键
     * @return 结果
     */
    public int deleteGoodsById(Long id);

    /**
     * 批量删除Product table
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGoodsByIds(Long[] ids);
}
