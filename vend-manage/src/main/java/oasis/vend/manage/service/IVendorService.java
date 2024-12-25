package oasis.vend.manage.service;

import java.util.List;
import oasis.vend.manage.domain.Vendor;
import oasis.vend.manage.domain.custom.VendorCustom;

/**
 * vendorService接口
 * 
 * @author oasis
 * @date 2024-12-23
 */
public interface IVendorService 
{
    /**
     * 查询vendor
     * 
     * @param id vendor主键
     * @return vendor
     */
    public Vendor selectVendorById(Long id);

    /**
     * 查询vendor列表
     * 
     * @param vendor vendor
     * @return vendor集合
     */
    public List<Vendor> selectVendorList(Vendor vendor);

    /**
     * 新增vendor
     * 
     * @param vendor vendor
     * @return 结果
     */
    public int insertVendor(Vendor vendor);

    /**
     * 修改vendor
     * 
     * @param vendor vendor
     * @return 结果
     */
    public int updateVendor(Vendor vendor);

    /**
     * 批量删除vendor
     * 
     * @param ids 需要删除的vendor主键集合
     * @return 结果
     */
    public int deleteVendorByIds(Long[] ids);

    /**
     * 删除vendor信息
     * 
     * @param id vendor主键
     * @return 结果
     */
    public int deleteVendorById(Long id);
    
	/**
	 * 查询vendor列表
	 * 
	 * @param vendorCustom vendor
	 * @return vendor集合
	 */
    public List<VendorCustom>	selectVendorCustomList(Vendor v);
}
