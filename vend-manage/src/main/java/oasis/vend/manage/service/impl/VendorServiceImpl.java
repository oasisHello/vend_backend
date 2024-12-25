package oasis.vend.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oasis.vend.manage.mapper.VendorMapper;
import oasis.vend.manage.domain.Vendor;
import oasis.vend.manage.domain.custom.VendorCustom;
import oasis.vend.manage.service.IVendorService;

/**
 * vendorService业务层处理
 * 
 * @author oasis
 * @date 2024-12-23
 */
@Service
public class VendorServiceImpl implements IVendorService 
{
    @Autowired
    private VendorMapper vendorMapper;

    /**
     * 查询vendor
     * 
     * @param id vendor主键
     * @return vendor
     */
    @Override
    public Vendor selectVendorById(Long id)
    {
        return vendorMapper.selectVendorById(id);
    }

    /**
     * 查询vendor列表
     * 
     * @param vendor vendor
     * @return vendor
     */
    @Override
    public List<Vendor> selectVendorList(Vendor vendor)
    {
        return vendorMapper.selectVendorList(vendor);
    }

    /**
     * 新增vendor
     * 
     * @param vendor vendor
     * @return 结果
     */
    @Override
    public int insertVendor(Vendor vendor)
    {
        return vendorMapper.insertVendor(vendor);
    }

    /**
     * 修改vendor
     * 
     * @param vendor vendor
     * @return 结果
     */
    @Override
    public int updateVendor(Vendor vendor)
    {
        return vendorMapper.updateVendor(vendor);
    }

    /**
     * 批量删除vendor
     * 
     * @param ids 需要删除的vendor主键
     * @return 结果
     */
    @Override
    public int deleteVendorByIds(Long[] ids)
    {
        return vendorMapper.deleteVendorByIds(ids);
    }

    /**
     * 删除vendor信息
     * 
     * @param id vendor主键
     * @return 结果
     */
    @Override
    public int deleteVendorById(Long id)
    {
        return vendorMapper.deleteVendorById(id);
    }

	/**
	 * 查询vendor列表
	 * 
	 * @param vendorCustom v
	 * @return vendor集合
	 */
	@Override
	public List<VendorCustom> selectVendorCustomList(Vendor v) {

		return vendorMapper.selectVendorCustomList(v);
	}
}
