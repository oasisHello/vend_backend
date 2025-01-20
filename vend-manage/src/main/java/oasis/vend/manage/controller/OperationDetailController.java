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
import oasis.vend.manage.domain.OperationDetail;
import oasis.vend.manage.service.IOperationDetailService;
import oasis.vend.common.utils.poi.ExcelUtil;
import oasis.vend.common.core.page.TableDataInfo;

/**
 * Operation detail tableController
 * 
 * @author oasis
 * @date 2025-01-20
 */
@RestController
@RequestMapping("/manage/operationDetail")
public class OperationDetailController extends BaseController
{
    @Autowired
    private IOperationDetailService operationDetailService;

    /**
     * 查询Operation detail table列表
     */
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
    @PreAuthorize("@ss.hasPermi('manage:operationDetail:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(operationDetailService.selectOperationDetailById(id));
    }

    /**
     * 新增Operation detail table
     */
    @PreAuthorize("@ss.hasPermi('manage:operationDetail:add')")
    @Log(title = "Operation detail table", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OperationDetail operationDetail)
    {
        return toAjax(operationDetailService.insertOperationDetail(operationDetail));
    }

    /**
     * 修改Operation detail table
     */
    @PreAuthorize("@ss.hasPermi('manage:operationDetail:edit')")
    @Log(title = "Operation detail table", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OperationDetail operationDetail)
    {
        return toAjax(operationDetailService.updateOperationDetail(operationDetail));
    }

    /**
     * 删除Operation detail table
     */
    @PreAuthorize("@ss.hasPermi('manage:operationDetail:remove')")
    @Log(title = "Operation detail table", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(operationDetailService.deleteOperationDetailByIds(ids));
    }
}
