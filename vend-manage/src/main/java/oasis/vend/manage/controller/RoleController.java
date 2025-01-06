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
import oasis.vend.manage.domain.Role;
import oasis.vend.manage.service.IRoleService;
import oasis.vend.common.utils.poi.ExcelUtil;
import oasis.vend.common.core.page.TableDataInfo;

/**
 * Role ListController
 * 
 * @author oasis
 * @date 2024-12-31
 */
@RestController
@RequestMapping("/manage/role")
public class RoleController extends BaseController
{
    @Autowired
    private IRoleService roleService;

    /**
     * 查询Role List列表
     */
    @PreAuthorize("@ss.hasPermi('manage:role:list')")
    @GetMapping("/list")
    public TableDataInfo list(Role role)
    {
        startPage();
        List<Role> list = roleService.selectRoleList(role);
        return getDataTable(list);
    }

    /**
     * 导出Role List列表
     */
    @PreAuthorize("@ss.hasPermi('manage:role:export')")
    @Log(title = "Role List", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Role role)
    {
        List<Role> list = roleService.selectRoleList(role);
        ExcelUtil<Role> util = new ExcelUtil<Role>(Role.class);
        util.exportExcel(response, list, "Role List数据");
    }

    /**
     * 获取Role List详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:role:query')")
    @GetMapping(value = "/{roleId}")
    public AjaxResult getInfo(@PathVariable("roleId") Long roleId)
    {
        return success(roleService.selectRoleByRoleId(roleId));
    }

    /**
     * 新增Role List
     */
    @PreAuthorize("@ss.hasPermi('manage:role:add')")
    @Log(title = "Role List", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Role role)
    {
        return toAjax(roleService.insertRole(role));
    }

    /**
     * 修改Role List
     */
    @PreAuthorize("@ss.hasPermi('manage:role:edit')")
    @Log(title = "Role List", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Role role)
    {
        return toAjax(roleService.updateRole(role));
    }

    /**
     * 删除Role List
     */
    @PreAuthorize("@ss.hasPermi('manage:role:remove')")
    @Log(title = "Role List", businessType = BusinessType.DELETE)
	@DeleteMapping("/{roleIds}")
    public AjaxResult remove(@PathVariable Long[] roleIds)
    {
        return toAjax(roleService.deleteRoleByRoleIds(roleIds));
    }
}
