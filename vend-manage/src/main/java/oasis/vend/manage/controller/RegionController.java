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
import oasis.vend.manage.domain.Region;
import oasis.vend.manage.service.IRegionService;
import oasis.vend.common.utils.poi.ExcelUtil;
import oasis.vend.common.core.page.TableDataInfo;

/**
 * regionController
 * 
 * @author ruoyi
 * @date 2024-12-23
 */
@RestController
@RequestMapping("/manage/region")
public class RegionController extends BaseController
{
    @Autowired
    private IRegionService regionService;

    /**
     * 查询region列表
     */
    @PreAuthorize("@ss.hasPermi('manage:region:list')")
    @GetMapping("/list")
    public TableDataInfo list(Region region)
    {
        startPage();
        List<Region> list = regionService.selectRegionList(region);
        return getDataTable(list);
    }

    /**
     * 导出region列表
     */
    @PreAuthorize("@ss.hasPermi('manage:region:export')")
    @Log(title = "region", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Region region)
    {
        List<Region> list = regionService.selectRegionList(region);
        ExcelUtil<Region> util = new ExcelUtil<Region>(Region.class);
        util.exportExcel(response, list, "region数据");
    }

    /**
     * 获取region详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:region:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(regionService.selectRegionById(id));
    }

    /**
     * 新增region
     */
    @PreAuthorize("@ss.hasPermi('manage:region:add')")
    @Log(title = "region", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Region region)
    {
        return toAjax(regionService.insertRegion(region));
    }

    /**
     * 修改region
     */
    @PreAuthorize("@ss.hasPermi('manage:region:edit')")
    @Log(title = "region", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Region region)
    {
        return toAjax(regionService.updateRegion(region));
    }

    /**
     * 删除region
     */
    @PreAuthorize("@ss.hasPermi('manage:region:remove')")
    @Log(title = "region", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(regionService.deleteRegionByIds(ids));
    }
}
