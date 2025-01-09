package oasis.vend.manage.service.impl;

import java.util.List;
import oasis.vend.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oasis.vend.manage.mapper.VendingMachineMapper;
import oasis.vend.manage.domain.VendingMachine;
import oasis.vend.manage.service.IVendingMachineService;

/**
 * Vending Machine ManageService业务层处理
 * 
 * @author oasis
 * @date 2025-01-07
 */
@Service
public class VendingMachineServiceImpl implements IVendingMachineService 
{
    @Autowired
    private VendingMachineMapper vendingMachineMapper;

    /**
     * 查询Vending Machine Manage
     * 
     * @param id Vending Machine Manage主键
     * @return Vending Machine Manage
     */
    @Override
    public VendingMachine selectVendingMachineById(Long id)
    {
        return vendingMachineMapper.selectVendingMachineById(id);
    }

    /**
     * 查询Vending Machine Manage列表
     * 
     * @param vendingMachine Vending Machine Manage
     * @return Vending Machine Manage
     */
    @Override
    public List<VendingMachine> selectVendingMachineList(VendingMachine vendingMachine)
    {
        return vendingMachineMapper.selectVendingMachineList(vendingMachine);
    }

    /**
     * 新增Vending Machine Manage
     * 
     * @param vendingMachine Vending Machine Manage
     * @return 结果
     */
    @Override
    public int insertVendingMachine(VendingMachine vendingMachine)
    {
        vendingMachine.setCreateTime(DateUtils.getNowDate());
        return vendingMachineMapper.insertVendingMachine(vendingMachine);
    }

    /**
     * 修改Vending Machine Manage
     * 
     * @param vendingMachine Vending Machine Manage
     * @return 结果
     */
    @Override
    public int updateVendingMachine(VendingMachine vendingMachine)
    {
        vendingMachine.setUpdateTime(DateUtils.getNowDate());
        return vendingMachineMapper.updateVendingMachine(vendingMachine);
    }

    /**
     * 批量删除Vending Machine Manage
     * 
     * @param ids 需要删除的Vending Machine Manage主键
     * @return 结果
     */
    @Override
    public int deleteVendingMachineByIds(Long[] ids)
    {
        return vendingMachineMapper.deleteVendingMachineByIds(ids);
    }

    /**
     * 删除Vending Machine Manage信息
     * 
     * @param id Vending Machine Manage主键
     * @return 结果
     */
    @Override
    public int deleteVendingMachineById(Long id)
    {
        return vendingMachineMapper.deleteVendingMachineById(id);
    }
}
