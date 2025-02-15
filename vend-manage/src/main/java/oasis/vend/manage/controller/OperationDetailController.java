package oasis.vend.manage.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import oasis.vend.common.core.domain.R;
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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import oasis.vend.common.annotation.Log;
import oasis.vend.common.core.controller.BaseController;
import oasis.vend.common.core.domain.AjaxResult;
import oasis.vend.common.enums.BusinessType;
import oasis.vend.manage.domain.OperationDetail;
import oasis.vend.manage.service.IOperationDetailService;
import oasis.vend.common.utils.poi.ExcelUtil;
import oasis.vend.common.core.page.TableDataInfo;

import static oasis.vend.common.core.domain.R.ok;

/**
 * Operation detail tableController
 *
 * @author oasis
 * @date 2025-01-20
 */
@Api(tags = "Operation Detail Management") // Tag for Knife4J to group this controller
@RestController
@RequestMapping("/manage/operationDetail")
public class OperationDetailController extends BaseController
{
    @Autowired
    private IOperationDetailService operationDetailService;

    /**
     * 查询Operation detail table列表
     */
    @ApiOperation(value = "Get Operation Detail List", notes = "Fetch a list of operation details")
    @PreAuthorize("@ss.hasPermi('manage:operationDetail:list')")
    @GetMapping("/list")
    public TableDataInfo list(OperationDetail operationDetail)
    {
        startPage();
        List<OperationDetail> list = operationDetailService.selectOperationDetailList(operationDetail);
        return getDataTable(list);
    }

    /**
     * 导出Operation detail table列表
     */
    @ApiOperation(value = "Export Operation Detail List", notes = "Export a list of operation details to Excel")
    @PreAuthorize("@ss.hasPermi('manage:operationDetail:export')")
    @Log(title = "Operation detail table", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OperationDetail operationDetail)
    {
        List<OperationDetail> list = operationDetailService.selectOperationDetailList(operationDetail);
        ExcelUtil<OperationDetail> util = new ExcelUtil<OperationDetail>(OperationDetail.class);
        util.exportExcel(response, list, "Operation detail table数据");
    }

    /**
     * 获取Operation detail table详细信息
     */
    @ApiOperation(value = "Get Operation Detail Info", notes = "Fetch details of a specific operation detail by ID")
    @PreAuthorize("@ss.hasPermi('manage:operationDetail:query')")
    @GetMapping(value = "/{id}")
    public R<OperationDetail> getInfo(@PathVariable("id") Long id)
    {
        return ok(operationDetailService.selectOperationDetailById(id));
    }

    /**
     * 新增Operation detail table
     */
    @ApiOperation(value = "Add Operation Detail", notes = "Add a new operation detail")
    @PreAuthorize("@ss.hasPermi('manage:operationDetail:add')")
    @Log(title = "Operation detail table", businessType = BusinessType.INSERT)
    @PostMapping
    public R<String> add(@RequestBody OperationDetail operationDetail)
    {
        operationDetailService.insertOperationDetail(operationDetail);
        return R.ok();
    }

    /**
     * 修改Operation detail table
     */
    @ApiOperation(value = "Edit Operation Detail", notes = "Edit an existing operation detail")
    @PreAuthorize("@ss.hasPermi('manage:operationDetail:edit')")
    @Log(title = "Operation detail table", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<String> edit(@RequestBody OperationDetail operationDetail)
    {
        return R.ok();
    }

    /**
     * 删除Operation detail table
     */
    @ApiOperation(value = "Delete Operation Details", notes = "Delete operation details by IDs")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "IDs of operation details to delete", required = true, dataType = "Long[]", paramType = "path")
    })
    @PreAuthorize("@ss.hasPermi('manage:operationDetail:remove')")
    @Log(title = "Operation detail table", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(operationDetailService.deleteOperationDetailByIds(ids));
    }
}
