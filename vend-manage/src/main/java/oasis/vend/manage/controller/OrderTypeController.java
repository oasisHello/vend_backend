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
import oasis.vend.manage.domain.OrderType;
import oasis.vend.manage.service.IOrderTypeService;
import oasis.vend.common.utils.poi.ExcelUtil;
import oasis.vend.common.core.page.TableDataInfo;

/**
 * Order type tableController
 * 
 * @author oasis
 * @date 2025-01-20
 */
@RestController
@RequestMapping("/manage/order_type")
public class OrderTypeController extends BaseController
{
    @Autowired
    private IOrderTypeService orderTypeService;

    /**
     * 查询Order type table列表
     */
    @PreAuthorize("@ss.hasPermi('manage:order_type:list')")
    @GetMapping("/list")
    public TableDataInfo list(OrderType orderType)
    {
        startPage();
        List<OrderType> list = orderTypeService.selectOrderTypeList(orderType);
        return getDataTable(list);
    }

    /**
     * 导出Order type table列表
     */
    @PreAuthorize("@ss.hasPermi('manage:order_type:export')")
    @Log(title = "Order type table", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OrderType orderType)
    {
        List<OrderType> list = orderTypeService.selectOrderTypeList(orderType);
        ExcelUtil<OrderType> util = new ExcelUtil<OrderType>(OrderType.class);
        util.exportExcel(response, list, "Order type table数据");
    }

    /**
     * 获取Order type table详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:order_type:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(orderTypeService.selectOrderTypeById(id));
    }

    /**
     * 新增Order type table
     */
    @PreAuthorize("@ss.hasPermi('manage:order_type:add')")
    @Log(title = "Order type table", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OrderType orderType)
    {
        return toAjax(orderTypeService.insertOrderType(orderType));
    }

    /**
     * 修改Order type table
     */
    @PreAuthorize("@ss.hasPermi('manage:order_type:edit')")
    @Log(title = "Order type table", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OrderType orderType)
    {
        return toAjax(orderTypeService.updateOrderType(orderType));
    }

    /**
     * 删除Order type table
     */
    @PreAuthorize("@ss.hasPermi('manage:order_type:remove')")
    @Log(title = "Order type table", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(orderTypeService.deleteOrderTypeByIds(ids));
    }
}
