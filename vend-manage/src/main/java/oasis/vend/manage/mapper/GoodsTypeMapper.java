package oasis.vend.manage.mapper;

import java.util.List;
import oasis.vend.manage.domain.GoodsType;

/**
 * Product type tableMapper接口
 * 
 * @author oasis
 * @date 2025-01-14
 */
public interface GoodsTypeMapper 
{
    /**
     * 查询Product type table
     * 
     * @param id Product type table主键
     * @return Product type table
     */
    public GoodsType selectGoodsTypeById(Long id);

    /**
     * 查询Product type table列表
     * 
     * @param goodsType Product type table
     * @return Product type table集合
     */
    public List<GoodsType> selectGoodsTypeList(GoodsType goodsType);

    /**
     * 新增Product type table
     * 
     * @param goodsType Product type table
     * @return 结果
     */
    public int insertGoodsType(GoodsType goodsType);

    /**
     * 修改Product type table
     * 
     * @param goodsType Product type table
     * @return 结果
     */
    public int updateGoodsType(GoodsType goodsType);

    /**
     * 删除Product type table
     * 
     * @param id Product type table主键
     * @return 结果
     */
    public int deleteGoodsTypeById(Long id);

    /**
     * 批量删除Product type table
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGoodsTypeByIds(Long[] ids);
}
