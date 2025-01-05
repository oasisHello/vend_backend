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
import oasis.vend.manage.domain.Aisle;
import oasis.vend.manage.service.IAisleService;
import oasis.vend.common.utils.poi.ExcelUtil;
import oasis.vend.common.core.page.TableDataInfo;

/**
 * Aisle InformationController
 * 
 * @author oasis
 * @date 2025-01-04
 */
@RestController
@RequestMapping("/manage/aisle")
public class AisleController extends BaseController
{
    @Autowired
    private IAisleService aisleService;

    /**
     * 查询Aisle Information列表
     */
    @PreAuthorize("@ss.hasPermi('manage:aisle:list')")
    @GetMapping("/list")
    public TableDataInfo list(Aisle aisle)
    {
        startPage();
        List<Aisle> list = aisleService.selectAisleList(aisle);
        return getDataTable(list);
    }

    /**
     * 导出Aisle Information列表
     */
    @PreAuthorize("@ss.hasPermi('manage:aisle:export')")
    @Log(title = "Aisle Information", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Aisle aisle)
    {
        List<Aisle> list = aisleService.selectAisleList(aisle);
        ExcelUtil<Aisle> util = new ExcelUtil<Aisle>(Aisle.class);
        util.exportExcel(response, list, "Aisle Information数据");
    }

    /**
     * 获取Aisle Information详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:aisle:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(aisleService.selectAisleById(id));
    }

    /**
     * 新增Aisle Information
     */
    @PreAuthorize("@ss.hasPermi('manage:aisle:add')")
    @Log(title = "Aisle Information", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Aisle aisle)
    {
        return toAjax(aisleService.insertAisle(aisle));
    }

    /**
     * 修改Aisle Information
     */
    @PreAuthorize("@ss.hasPermi('manage:aisle:edit')")
    @Log(title = "Aisle Information", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Aisle aisle)
    {
        return toAjax(aisleService.updateAisle(aisle));
    }

    /**
     * 删除Aisle Information
     */
    @PreAuthorize("@ss.hasPermi('manage:aisle:remove')")
    @Log(title = "Aisle Information", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(aisleService.deleteAisleByIds(ids));
    }
}
