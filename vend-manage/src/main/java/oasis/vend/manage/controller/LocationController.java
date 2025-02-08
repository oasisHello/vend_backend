package oasis.vend.manage.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
import oasis.vend.common.core.domain.R;
import oasis.vend.common.enums.BusinessType;
import oasis.vend.manage.domain.Location;
import oasis.vend.manage.service.ILocationService;
import oasis.vend.common.utils.poi.ExcelUtil;
import oasis.vend.common.core.page.TableDataInfo;

/**
 * locationController
 *
 * @author oasis
 * @date 2025-02-08
 */
@RestController
@Api(tags="locationController")
@RequestMapping("/manage/location")
public class LocationController extends BaseController
{
	@Autowired
	private ILocationService locationService;

	/**
	 * query location list
	 */
	@ApiOperation("query location list")
	@PreAuthorize("@ss.hasPermi('manage:location:list')")
	@GetMapping("/list")
	public TableDataInfo list(Location location)
	{
		startPage();
		List<Location> list = locationService.selectLocationList(location);
		return getDataTable(list);
	}

	/**
	 * export location list
	 */
	@ApiOperation("export location list")
	@PreAuthorize("@ss.hasPermi('manage:location:export')")
	@Log(title = "location", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	public void export(HttpServletResponse response, Location location)
	{
		List<Location> list = locationService.selectLocationList(location);
		ExcelUtil<Location> util = new ExcelUtil<Location>(Location.class);
		util.exportExcel(response, list, "location数据");
	}

	/**
	 * retrieve location detailed info
	 */
	@ApiOperation("retrieve location detailed info")
	@PreAuthorize("@ss.hasPermi('manage:location:query')")
	@GetMapping(value = "/{id}")
	public R<Location> getInfo(@PathVariable("id") Long id)
	{

		return R.ok(locationService.selectLocationById(id));
	}

	/**
	 * add location
	 */
	@ApiOperation("add location")
	@PreAuthorize("@ss.hasPermi('manage:location:add')")
	@Log(title = "location", businessType = BusinessType.INSERT)
	@PostMapping
	public R<String> add(@RequestBody Location location)
	{
		locationService.insertLocation(location);
		return R.ok();
	}

	/**
	 * modify location
	 */
	@ApiOperation("modify location")
	@PreAuthorize("@ss.hasPermi('manage:location:edit')")
	@Log(title = "location", businessType = BusinessType.UPDATE)
	@PutMapping
	public R<String> edit(@RequestBody Location location)
	{
		locationService.updateLocation(location);
		return R.ok();
	}

	/**
	 * delete location
	 */
	@ApiOperation("delete location")
	@PreAuthorize("@ss.hasPermi('manage:location:remove')")
	@Log(title = "location", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
	public R<String> remove(@PathVariable Long[] ids)
	{
		locationService.deleteLocationByIds(ids);
		return R.ok();
	}
}
