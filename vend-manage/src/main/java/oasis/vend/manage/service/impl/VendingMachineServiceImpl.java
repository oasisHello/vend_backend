package oasis.vend.manage.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import oasis.vend.common.constant.VM;
import oasis.vend.common.utils.DateUtils;
import oasis.vend.common.utils.uuid.UUIDUtils;

import org.apache.ibatis.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oasis.vend.manage.mapper.AisleMapper;
import oasis.vend.manage.mapper.VendingMachineMapper;
import oasis.vend.manage.domain.Aisle;
import oasis.vend.manage.domain.Location;
import oasis.vend.manage.domain.VendingMachine;
import oasis.vend.manage.domain.VmType;
import oasis.vend.manage.service.IAisleService;
import oasis.vend.manage.service.ILocationService;
import oasis.vend.manage.service.IVendingMachineService;
import oasis.vend.manage.service.IVmTypeService;

/**
 * Vending Machine ManageService业务层处理
 * 
 * @author oasis
 * @date 2025-01-07
 */
@Service
public class VendingMachineServiceImpl implements IVendingMachineService {

	@Autowired
	private VendingMachineMapper vendingMachineMapper;
	@Autowired
	private IVmTypeService vmTypeService;
	@Autowired
	private ILocationService locationService;
	@Autowired
	private IAisleService aisleService;

	/**
	 * 查询Vending Machine Manage
	 * 
	 * @param id Vending Machine Manage主键
	 * @return Vending Machine Manage
	 */
	@Override
	public VendingMachine selectVendingMachineById(Long id) {
		return vendingMachineMapper.selectVendingMachineById(id);
	}

	/**
	 * 查询Vending Machine Manage列表
	 * 
	 * @param vendingMachine Vending Machine Manage
	 * @return Vending Machine Manage
	 */
	@Override
	public List<VendingMachine> selectVendingMachineList(VendingMachine vendingMachine) {
		return vendingMachineMapper.selectVendingMachineList(vendingMachine);
	}

	/**
	 * 新增Vending Machine Manage
	 * 
	 * @param vendingMachine Vending Machine Manage
	 * @return 结果
	 */
	@Transactional
	@Override
	public int insertVendingMachine(VendingMachine vendingMachine) {
		// 1. insert vending machine
		vendingMachine.setInnerCode(UUIDUtils.getUUID());// 1.1 auto fill inner code by UUIDUtils
		// 1.2 fill the aisle max capacity by vmType
		VmType vmType = vmTypeService.selectVmTypeById(vendingMachine.getVmTypeId());
		vendingMachine.setAisleMaxCapacity(vmType.getAisleMaxCapacity());
		// 1.3 fill address by location
		Location location = locationService.selectLocationById(vendingMachine.getLocationId());
		vendingMachine.setAddress(location.getAddress());
		// 1.4 business area by location
		vendingMachine.setBusinessArea(location.getBusinessArea());
		// 1.5 region id by location
		vendingMachine.setRegionId(location.getRegionId());
		// 1.6 vendor id by location
		vendingMachine.setVendorId(location.getVendorId());
		// 1.7 VM status undeploy as default
		vendingMachine.setVmStatus(VM.STATUS_UNDEPLOY);
		// 1.8 create time
		vendingMachine.setCreateTime(DateUtils.getNowDate());
		// 1.9 update time
		vendingMachine.setUpdateTime(DateUtils.getNowDate());
		// 1.10 save vending machine
		int result = vendingMachineMapper.insertVendingMachine(vendingMachine);

		// 2. insert aisle of vending machine
		List<Aisle> aisles = new ArrayList<Aisle>();
		for (int i = 1; i <= vmType.getRowCount(); i++) {
			for (int j = 1; j <= vmType.getColCount(); j++) {
				Aisle aisle = new Aisle();
				aisle.setCode(i + "_" + j);
				aisle.setVmId(vendingMachine.getId());
				aisle.setInnerCode(vendingMachine.getInnerCode());
				aisle.setMaxCapacity(vmType.getAisleMaxCapacity());
				aisle.setCreateTime(DateUtils.getNowDate());
				aisle.setUpdateTime(DateUtils.getNowDate());
				aisles.add(aisle);
			}
		}
		// save aisles
		aisleService.insertAisleBatch(aisles);

		return result;
	}

	/**
	 * 修改Vending Machine Manage
	 * 
	 * @param vendingMachine Vending Machine Manage
	 * @return 结果
	 */
	@Override
	public int updateVendingMachine(VendingMachine vendingMachine) {
		// 1. update vending machine
		// 1.1 fill update time
		vendingMachine.setUpdateTime(DateUtils.getNowDate());
		// 1.2 set location id
		Location location = locationService.selectLocationById(vendingMachine.getLocationId());
		vendingMachine.setAddress(location.getAddress());
		// 1.3set location address
		vendingMachine.setAddress(location.getAddress());
		// 1.4set business area by location
		vendingMachine.setBusinessArea(location.getBusinessArea());
		// 1.5set region id by location
		vendingMachine.setRegionId(location.getRegionId());
		// 1.6set vendor id by location
		
		
		return vendingMachineMapper.updateVendingMachine(vendingMachine);
	}

	/**
	 * 批量删除Vending Machine Manage
	 * 
	 * @param ids 需要删除的Vending Machine Manage主键
	 * @return 结果
	 */
	@Override
	public int deleteVendingMachineByIds(Long[] ids) {
		return vendingMachineMapper.deleteVendingMachineByIds(ids);
	}

	/**
	 * 删除Vending Machine Manage信息
	 * 
	 * @param id Vending Machine Manage主键
	 * @return 结果
	 */
	@Override
	public int deleteVendingMachineById(Long id) {
		return vendingMachineMapper.deleteVendingMachineById(id);
	}
}
