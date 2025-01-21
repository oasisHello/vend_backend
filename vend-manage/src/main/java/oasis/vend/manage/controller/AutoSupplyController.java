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
import oasis.vend.manage.domain.AutoSupply;
import oasis.vend.manage.service.IAutoSupplyService;
import oasis.vend.common.utils.poi.ExcelUtil;
import oasis.vend.common.core.page.TableDataInfo;

/**
 * auto supplyController
 *
 * @author oasis
 * @date 2025-01-20
 */
@RestController
@RequestMapping("/manage/autoSupply")
public class AutoSupplyController extends BaseController {
    @Autowired
    private IAutoSupplyService autoSupplyService;

    /**
     * 查询auto supply列表
     */
    @PreAuthorize("@ss.hasPermi('manage:autoSupply:list')")
    @GetMapping("/list")
    public TableDataInfo list(AutoSupply autoSupply) {
        startPage();
        List<AutoSupply> list = autoSupplyService.selectAutoSupplyList(autoSupply);
        return getDataTable(list);
    }

    /**
     * 导出auto supply列表
     */
    @PreAuthorize("@ss.hasPermi('manage:autoSupply:export')")
    @Log(title = "auto supply", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AutoSupply autoSupply) {
        List<AutoSupply> list = autoSupplyService.selectAutoSupplyList(autoSupply);
        ExcelUtil<AutoSupply> util = new ExcelUtil<AutoSupply>(AutoSupply.class);
        util.exportExcel(response, list, "auto supply数据");
    }

    /**
     * 获取auto supply详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:autoSupply:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(autoSupplyService.selectAutoSupplyById(id));
    }

    /**
     * 新增auto supply
     */
    @PreAuthorize("@ss.hasPermi('manage:autoSupply:add')")
    @Log(title = "auto supply", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AutoSupply autoSupply) {
        return toAjax(autoSupplyService.insertAutoSupply(autoSupply));
    }

    /**
     * 修改auto supply
     */
    @PreAuthorize("@ss.hasPermi('manage:autoSupply:edit')")
    @Log(title = "auto supply", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AutoSupply autoSupply) {
        return toAjax(autoSupplyService.updateAutoSupply(autoSupply));
    }

    /**
     * 删除auto supply
     */
    @PreAuthorize("@ss.hasPermi('manage:autoSupply:remove')")
    @Log(title = "auto supply", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(autoSupplyService.deleteAutoSupplyByIds(ids));
    }
}
