package oasis.vend.manage.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import oasis.vend.common.utils.DateUtils;
import oasis.vend.manage.domain.custom.AisleCustom;
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
 * @date 2025-01-07
 */
@Api(tags = "Aisle Management")  // Tag for Knife4J API grouping
@RestController
@RequestMapping("/manage/aisle")
public class AisleController extends BaseController
{
    @Autowired
    private IAisleService aisleService;

    /**
     * Query Aisle Information List
     */
    @ApiOperation(value = "Get aisle list", notes = "Retrieve the list of aisles")
    @PreAuthorize("@ss.hasPermi('manage:aisle:list')")
    @GetMapping("/list")
    public TableDataInfo list(Aisle aisle)
    {
        startPage();
        List<Aisle> list = aisleService.selectAisleList(aisle);
        return getDataTable(list);
    }

    /**
     * Export Aisle Information List
     */
    @ApiOperation(value = "Export aisle list", notes = "Export the aisle list as an Excel file")
    @PreAuthorize("@ss.hasPermi('manage:aisle:export')")
    @Log(title = "Aisle Information", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Aisle aisle)
    {
        List<Aisle> list = aisleService.selectAisleList(aisle);
        ExcelUtil<Aisle> util = new ExcelUtil<Aisle>(Aisle.class);
        util.exportExcel(response, list, "Aisle Information Data");
    }

    /**
     * Get Aisle Information Details
     */
    @ApiOperation(value = "Get aisle details", notes = "Get detailed information of a specific aisle by ID")
    @PreAuthorize("@ss.hasPermi('manage:aisle:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(aisleService.selectAisleById(id));
    }

    /**
     * Add Aisle Information
     */
    @ApiOperation(value = "Add new aisle", notes = "Add a new aisle information")
    @PreAuthorize("@ss.hasPermi('manage:aisle:add')")
    @Log(title = "Aisle Information", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Aisle aisle)
    {
        return toAjax(aisleService.insertAisle(aisle));
    }

    /**
     * Edit Aisle Information
     */
    @ApiOperation(value = "Edit aisle", notes = "Edit an existing aisle information")
    @PreAuthorize("@ss.hasPermi('manage:aisle:edit')")
    @Log(title = "Aisle Information", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Aisle aisle)
    {
        return toAjax(aisleService.updateAisle(aisle));
    }

    /**
     * Delete Aisle Information
     */
    @ApiOperation(value = "Delete aisle", notes = "Delete a specified aisle information")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "Aisle IDs to be deleted", required = true, dataType = "Long[]", paramType = "path")
    })
    @PreAuthorize("@ss.hasPermi('manage:aisle:remove')")
    @Log(title = "Aisle Information", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(aisleService.deleteAisleByIds(ids));
    }

    /**
     * Get AisleCustom List
     */
    @ApiOperation(value = "Get AisleCustom list", notes = "Get the list of AisleCustom based on innerCode")
    @PreAuthorize("@ss.hasPermi('manage:aisle:list')")
    @GetMapping(value = "/list_by_vmcode")
    public TableDataInfo getAisleCustomList(Aisle aisle)
    {
        startPage();
        List<AisleCustom>  aisleList = aisleService.selectAisleCustomByInnerCode(aisle.getInnerCode());
        return getDataTable(aisleList);
    }

    @ApiOperation(value = "Reset aisle", notes = "Reset the aisle to default")
    @PreAuthorize("@ss.hasPermi('manage:aisle:edit')")
    @Log(title = "Aisle Information", businessType = BusinessType.UPDATE)
    @PutMapping(value = "/reset")
    public AjaxResult reset(@RequestBody Aisle aisle)
    {
        aisle.setUpdateTime(DateUtils.getNowDate());
        return toAjax(aisleService.resetAisle(aisle));
    }

}
