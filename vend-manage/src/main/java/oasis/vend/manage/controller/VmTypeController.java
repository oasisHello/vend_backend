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
import oasis.vend.manage.domain.VmType;
import oasis.vend.manage.service.IVmTypeService;
import oasis.vend.common.utils.poi.ExcelUtil;
import oasis.vend.common.core.page.TableDataInfo;

/**
 * Vending Machine TypesController
 * 
 * @author oasis
 * @date 2025-01-04
 */
@RestController
@RequestMapping("/manage/vm_type")
public class VmTypeController extends BaseController
{
    @Autowired
    private IVmTypeService vmTypeService;

    /**
     * 查询Vending Machine Types列表
     */
    @PreAuthorize("@ss.hasPermi('manage:vm_type:list')")
    @GetMapping("/list")
    public TableDataInfo list(VmType vmType)
    {
        startPage();
        List<VmType> list = vmTypeService.selectVmTypeList(vmType);
        return getDataTable(list);
    }

    /**
     * 导出Vending Machine Types列表
     */
    @PreAuthorize("@ss.hasPermi('manage:vm_type:export')")
    @Log(title = "Vending Machine Types", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, VmType vmType)
    {
        List<VmType> list = vmTypeService.selectVmTypeList(vmType);
        ExcelUtil<VmType> util = new ExcelUtil<VmType>(VmType.class);
        util.exportExcel(response, list, "Vending Machine Types数据");
    }

    /**
     * 获取Vending Machine Types详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:vm_type:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(vmTypeService.selectVmTypeById(id));
    }

    /**
     * 新增Vending Machine Types
     */
    @PreAuthorize("@ss.hasPermi('manage:vm_type:add')")
    @Log(title = "Vending Machine Types", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody VmType vmType)
    {
        return toAjax(vmTypeService.insertVmType(vmType));
    }

    /**
     * 修改Vending Machine Types
     */
    @PreAuthorize("@ss.hasPermi('manage:vm_type:edit')")
    @Log(title = "Vending Machine Types", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody VmType vmType)
    {
        return toAjax(vmTypeService.updateVmType(vmType));
    }

    /**
     * 删除Vending Machine Types
     */
    @PreAuthorize("@ss.hasPermi('manage:vm_type:remove')")
    @Log(title = "Vending Machine Types", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(vmTypeService.deleteVmTypeByIds(ids));
    }
}
