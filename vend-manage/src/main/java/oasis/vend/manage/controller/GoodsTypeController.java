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
import oasis.vend.manage.domain.GoodsType;
import oasis.vend.manage.service.IGoodsTypeService;
import oasis.vend.common.utils.poi.ExcelUtil;
import oasis.vend.common.core.page.TableDataInfo;

/**
 * Product type tableController
 * 
 * @author oasis
 * @date 2025-01-14
 */
@RestController
@RequestMapping("/manage/goods_type")
public class GoodsTypeController extends BaseController
{
    @Autowired
    private IGoodsTypeService goodsTypeService;

    /**
     * 查询Product type table列表
     */
    @PreAuthorize("@ss.hasPermi('manage:goods_type:list')")
    @GetMapping("/list")
    public TableDataInfo list(GoodsType goodsType)
    {
        startPage();
        List<GoodsType> list = goodsTypeService.selectGoodsTypeList(goodsType);
        return getDataTable(list);
    }

    /**
     * 导出Product type table列表
     */
    @PreAuthorize("@ss.hasPermi('manage:goods_type:export')")
    @Log(title = "Product type table", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GoodsType goodsType)
    {
        List<GoodsType> list = goodsTypeService.selectGoodsTypeList(goodsType);
        ExcelUtil<GoodsType> util = new ExcelUtil<GoodsType>(GoodsType.class);
        util.exportExcel(response, list, "Product type table数据");
    }

    /**
     * 获取Product type table详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:goods_type:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(goodsTypeService.selectGoodsTypeById(id));
    }

    /**
     * 新增Product type table
     */
    @PreAuthorize("@ss.hasPermi('manage:goods_type:add')")
    @Log(title = "Product type table", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GoodsType goodsType)
    {
        return toAjax(goodsTypeService.insertGoodsType(goodsType));
    }

    /**
     * 修改Product type table
     */
    @PreAuthorize("@ss.hasPermi('manage:goods_type:edit')")
    @Log(title = "Product type table", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GoodsType goodsType)
    {
        return toAjax(goodsTypeService.updateGoodsType(goodsType));
    }

    /**
     * 删除Product type table
     */
    @PreAuthorize("@ss.hasPermi('manage:goods_type:remove')")
    @Log(title = "Product type table", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(goodsTypeService.deleteGoodsTypeByIds(ids));
    }
}
