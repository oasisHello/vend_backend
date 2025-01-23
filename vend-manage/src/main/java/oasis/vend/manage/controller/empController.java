package oasis.vend.manage.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import oasis.vend.manage.domain.VendingMachine;
import oasis.vend.manage.service.IRegionService;
import oasis.vend.manage.service.IVendingMachineService;
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
import oasis.vend.manage.domain.emp;
import oasis.vend.manage.mapper.RoleMapper;
import oasis.vend.manage.service.IempService;
import oasis.vend.common.utils.DateUtils;
import oasis.vend.common.utils.poi.ExcelUtil;
import oasis.vend.common.core.page.TableDataInfo;

import static oasis.vend.common.constant.VM.*;

/**
 * Employee ListController
 *
 * @author oasis
 * @date 2024-12-31
 */
@RestController
@RequestMapping("/manage/emp")
public class empController extends BaseController {
    @Autowired
    private IempService empService;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private IVendingMachineService vendingMachineService;

    /**
     * 查询Employee List列表
     */
    @PreAuthorize("@ss.hasPermi('manage:emp:list')")
    @GetMapping("/list")
    public TableDataInfo list(emp emp) {
        startPage();
        List<emp> list = empService.selectempList(emp);
        return getDataTable(list);
    }

    /**
     * 导出Employee List列表
     */
    @PreAuthorize("@ss.hasPermi('manage:emp:export')")
    @Log(title = "Employee List", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, emp emp) {
        List<emp> list = empService.selectempList(emp);
        ExcelUtil<emp> util = new ExcelUtil<emp>(emp.class);
        util.exportExcel(response, list, "Employee List数据");
    }

    /**
     * 获取Employee List详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:emp:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(empService.selectempById(id));
    }

    /**
     * 新增Employee List
     */
    @PreAuthorize("@ss.hasPermi('manage:emp:add')")
    @Log(title = "Employee List", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody emp emp) {
        // set role name
        emp.setRoleName(roleMapper.selectRoleByRoleId(emp.getRoleId()).getRoleName());

        return toAjax(empService.insertemp(emp));
    }

    /**
     * 修改Employee List
     */
    @PreAuthorize("@ss.hasPermi('manage:emp:edit')")
    @Log(title = "Employee List", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody emp emp) {
        // set role name
        emp.setRoleName(roleMapper.selectRoleByRoleId(emp.getRoleId()).getRoleName());
        emp.setUpdateTime(DateUtils.getNowDate());
        return toAjax(empService.updateemp(emp));
    }

    /**
     * 删除Employee List
     */
    @PreAuthorize("@ss.hasPermi('manage:emp:remove')")
    @Log(title = "Employee List", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(empService.deleteempByIds(ids));
    }

    @PreAuthorize("@ss.hasPermi('manage:emp:list')")
    @GetMapping("/listOperatorByInnerCode/{innerCode}")
    public AjaxResult listOperatorByInnerCode(@PathVariable("innerCode") String innerCode) {
        VendingMachine vm = vendingMachineService.selectVendingMachineByInnerCode(innerCode);
        if (vm == null) {
            return error();
        }
        emp anEmp = new emp();
        anEmp.setRegionId(vm.getRegionId());
        anEmp.setStatus(ENABLE_EMP);//1　enable
        anEmp.setRoleId(ROLE_OPERATOR);//Operator
        return success(empService.selectempList(anEmp));
    }

    @GetMapping("/listTechnicianByInnerCode/{innerCode}")
    public AjaxResult listTechnicianByInnerCode(@PathVariable("innerCode") String innerCode){
        VendingMachine vm = vendingMachineService.selectVendingMachineByInnerCode(innerCode);
        if (vm == null) {
            return error();
        }
        emp anEmp = new emp();
        anEmp.setRegionId(vm.getRegionId());
        anEmp.setStatus(ENABLE_EMP);//1　enable
        anEmp.setRoleId(ROLE_MAINTENANCE);//Maintenance
        return success(empService.selectempList(anEmp));
    }
}
