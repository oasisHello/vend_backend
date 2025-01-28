package oasis.vend.manage.service;

import java.util.List;
import oasis.vend.manage.domain.Aisle;
import oasis.vend.manage.domain.custom.AisleCustom;

/**
 * Aisle InformationService接口
 * 
 * @author oasis
 * @date 2025-01-07
 */
public interface IAisleService 
{
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
     * 批量删除Aisle Information
     * 
     * @param ids 需要删除的Aisle Information主键集合
     * @return 结果
     */
    public int deleteAisleByIds(Long[] ids);

    /**
     * 删除Aisle Information信息
     * 
     * @param id Aisle Information主键
     * @return 结果
     */
    public int deleteAisleById(Long id);
    
	/**
	 * insert aisle in a batch way
	 * 
	 * @param aisle Aisle Information
	 * @return 结果
	 */
     public void insertAisleBatch(List<Aisle> aisle);

    /**
     *  count the aisle by goods id
     */
    public int countByGoodsId(Long[] ids);

    /**
     * select AisleCustoms by innerCode
     *
     * @param innerCode
     * @return aisleCustom
     */

    public List<AisleCustom> selectAisleCustomByInnerCode(String innerCode);
}
