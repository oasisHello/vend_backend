package oasis.vend.manage.mapper;

import java.util.List;
import oasis.vend.manage.domain.Vendor;

/**
 * vendorMapper接口
 * 
 * @author oasis
 * @date 2024-12-23
 */
public interface VendorMapper 
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
     * 删除vendor
     * 
     * @param id vendor主键
     * @return 结果
     */
    public int deleteVendorById(Long id);

    /**
     * 批量删除vendor
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteVendorByIds(Long[] ids);
}
