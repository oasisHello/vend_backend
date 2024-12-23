package oasis.vend.manage.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import oasis.vend.common.annotation.Log;
import oasis.vend.common.core.controller.BaseController;
import oasis.vend.common.core.domain.AjaxResult;
import oasis.vend.common.enums.BusinessType;
import oasis.vend.manage.domain.Vendor;
import oasis.vend.manage.service.IVendorService;
import oasis.vend.common.utils.poi.ExcelUtil;
import oasis.vend.common.core.page.TableDataInfo;

/**
 * vendorController
 * 
 * @author oasis
 * @date 2024-12-23
 */
@RestController
@RequestMapping("/manage/vendor")
public class VendorController extends BaseController
{
    @Autowired
    private IVendorService vendorService;

    /**
     * 查询vendor列表
     */
    @PreAuthorize("@ss.hasPermi('manage:vendor:list')")
    @GetMapping("/list")
    public TableDataInfo list(Vendor vendor)
    {
        startPage();
        List<Vendor> list = vendorService.selectVendorList(vendor);
        return getDataTable(list);
    }

    /**
     * 导出vendor列表
     */
    @PreAuthorize("@ss.hasPermi('manage:vendor:export')")
    @Log(title = "vendor", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Vendor vendor)
    {
        List<Vendor> list = vendorService.selectVendorList(vendor);
        ExcelUtil<Vendor> util = new ExcelUtil<Vendor>(Vendor.class);
        util.exportExcel(response, list, "vendor数据");
    }

    /**
     * 获取vendor详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:vendor:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(vendorService.selectVendorById(id));
    }

    /**
     * 新增vendor
     */
    @PreAuthorize("@ss.hasPermi('manage:vendor:add')")
    @Log(title = "vendor", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Vendor vendor)
    {
        return toAjax(vendorService.insertVendor(vendor));
    }

    /**
     * 修改vendor
     */
    @PreAuthorize("@ss.hasPermi('manage:vendor:edit')")
    @Log(title = "vendor", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Vendor vendor)
    {
        return toAjax(vendorService.updateVendor(vendor));
    }

    /**
     * 删除vendor
     */
    @PreAuthorize("@ss.hasPermi('manage:vendor:remove')")
    @Log(title = "vendor", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(vendorService.deleteVendorByIds(ids));
    }
}
