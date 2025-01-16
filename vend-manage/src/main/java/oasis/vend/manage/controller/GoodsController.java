package oasis.vend.manage.controller;

import java.io.IOException;
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
import oasis.vend.manage.domain.Goods;
import oasis.vend.manage.service.IGoodsService;
import oasis.vend.common.utils.poi.ExcelUtil;
import oasis.vend.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * Product tableController
 *
 * @author oasis
 * @date 2025-01-14
 */
@RestController
@RequestMapping("/manage/goods")
public class GoodsController extends BaseController {
    @Autowired
    private IGoodsService goodsService;

    /**
     * 查询Product table列表
     */
    @PreAuthorize("@ss.hasPermi('manage:goods:list')")
    @GetMapping("/list")
    public TableDataInfo list(Goods goods) {
        startPage();
        List<Goods> list = goodsService.selectGoodsList(goods);
        return getDataTable(list);
    }

    /**
     * 导出Product table列表
     */
    @PreAuthorize("@ss.hasPermi('manage:goods:export')")
    @Log(title = "Product table", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Goods goods) {
        List<Goods> list = goodsService.selectGoodsList(goods);
        ExcelUtil<Goods> util = new ExcelUtil<Goods>(Goods.class);
        util.exportExcel(response, list, "Product table数据");
    }

    /**
     * 获取Product table详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:goods:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(goodsService.selectGoodsById(id));
    }

    /**
     * 新增Product table
     */
    @PreAuthorize("@ss.hasPermi('manage:goods:add')")
    @Log(title = "Product table", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Goods goods) {
        return toAjax(goodsService.insertGoods(goods));
    }

    /**
     * 修改Product table
     */
    @PreAuthorize("@ss.hasPermi('manage:goods:edit')")
    @Log(title = "Product table", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Goods goods) {
        return toAjax(goodsService.updateGoods(goods));
    }

    /**
     * 删除Product table
     */
    @PreAuthorize("@ss.hasPermi('manage:goods:remove')")
    @Log(title = "Product table", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(goodsService.deleteGoodsByIds(ids));
    }

    /**
     * insert goods from an excel file.
     */
    @PreAuthorize("@ss.hasPermi('manage:goods:add')")
    @Log(title = "Product table", businessType = BusinessType.IMPORT)
    @PostMapping("/import")
    public AjaxResult batchInsertByExcel(@RequestBody MultipartFile file) throws IOException { // NOTE:Catch or throw.
        ExcelUtil<Goods> util = new ExcelUtil<Goods>(Goods.class);
        List<Goods> goodsList = util.importExcel(file.getInputStream());// NOTE:why it needs a steam ?
        return toAjax(goodsService.batchInsert(goodsList));
    }
}
