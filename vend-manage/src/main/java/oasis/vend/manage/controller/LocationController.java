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
import oasis.vend.manage.domain.Location;
import oasis.vend.manage.service.ILocationService;
import oasis.vend.common.utils.poi.ExcelUtil;
import oasis.vend.common.core.page.TableDataInfo;

/**
 * locationController
 * 
 * @author ruoyi
 * @date 2024-12-23
 */
@RestController
@RequestMapping("/manage/location")
public class LocationController extends BaseController {
	@Autowired
	private ILocationService locationService;

	/**
	 * 查询location列表
	 */
	@PreAuthorize("@ss.hasPermi('manage:location:list')")
	@GetMapping("/list")
	public TableDataInfo list(Location location) {
		startPage();
		List<Location> list = locationService.selectLocationList(location);
		return getDataTable(list);
	}

	/**
	 * 导出location列表
	 */
	@PreAuthorize("@ss.hasPermi('manage:location:export')")
	@Log(title = "location", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	public void export(HttpServletResponse response, Location location) {
		List<Location> list = locationService.selectLocationList(location);
		ExcelUtil<Location> util = new ExcelUtil<Location>(Location.class);
		util.exportExcel(response, list, "location数据");
	}

	/**
	 * 获取location详细信息
	 */
	@PreAuthorize("@ss.hasPermi('manage:location:query')")
	@GetMapping(value = "/{id}")
	public AjaxResult getInfo(@PathVariable("id") Long id) {
		return success(locationService.selectLocationById(id));
	}

	/**
	 * 新增location
	 */
	@PreAuthorize("@ss.hasPermi('manage:location:add')")
	@Log(title = "location", businessType = BusinessType.INSERT)
	@PostMapping
	public AjaxResult add(@RequestBody Location location) {
		return toAjax(locationService.insertLocation(location));
	}

	/**
	 * 修改location
	 */
	@PreAuthorize("@ss.hasPermi('manage:location:edit')")
	@Log(title = "location", businessType = BusinessType.UPDATE)
	@PutMapping
	public AjaxResult edit(@RequestBody Location location) {
		return toAjax(locationService.updateLocation(location));
	}

	/**
	 * 删除location
	 */
	@PreAuthorize("@ss.hasPermi('manage:location:remove')")
	@Log(title = "location", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
	public AjaxResult remove(@PathVariable Long[] ids) {
		return toAjax(locationService.deleteLocationByIds(ids));
	}
}
