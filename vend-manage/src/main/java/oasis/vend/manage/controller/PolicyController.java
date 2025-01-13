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
import oasis.vend.manage.domain.Policy;
import oasis.vend.manage.service.IPolicyService;
import oasis.vend.common.utils.poi.ExcelUtil;
import oasis.vend.common.core.page.TableDataInfo;

/**
 * Policy InformationController
 * 
 * @author oasis
 * @date 2025-01-13
 */
@RestController
@RequestMapping("/manage/policy")
public class PolicyController extends BaseController
{
    @Autowired
    private IPolicyService policyService;

    /**
     * 查询Policy Information列表
     */
    @PreAuthorize("@ss.hasPermi('manage:policy:list')")
    @GetMapping("/list")
    public TableDataInfo list(Policy policy)
    {
        startPage();
        List<Policy> list = policyService.selectPolicyList(policy);
        return getDataTable(list);
    }

    /**
     * 导出Policy Information列表
     */
    @PreAuthorize("@ss.hasPermi('manage:policy:export')")
    @Log(title = "Policy Information", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Policy policy)
    {
        List<Policy> list = policyService.selectPolicyList(policy);
        ExcelUtil<Policy> util = new ExcelUtil<Policy>(Policy.class);
        util.exportExcel(response, list, "Policy Information数据");
    }

    /**
     * 获取Policy Information详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:policy:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(policyService.selectPolicyById(id));
    }

    /**
     * 新增Policy Information
     */
    @PreAuthorize("@ss.hasPermi('manage:policy:add')")
    @Log(title = "Policy Information", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Policy policy)
    {
        return toAjax(policyService.insertPolicy(policy));
    }

    /**
     * 修改Policy Information
     */
    @PreAuthorize("@ss.hasPermi('manage:policy:edit')")
    @Log(title = "Policy Information", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Policy policy)
    {
        return toAjax(policyService.updatePolicy(policy));
    }

    /**
     * 删除Policy Information
     */
    @PreAuthorize("@ss.hasPermi('manage:policy:remove')")
    @Log(title = "Policy Information", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(policyService.deletePolicyByIds(ids));
    }
}
