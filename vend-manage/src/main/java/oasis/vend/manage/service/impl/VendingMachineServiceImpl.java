package oasis.vend.manage.service.impl;

import java.util.List;
import oasis.vend.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oasis.vend.manage.mapper.VendingMachineMapper;
import oasis.vend.manage.domain.VendingMachine;
import oasis.vend.manage.service.IVendingMachineService;

/**
 * Vending Machine InformationService业务层处理
 * 
 * @author oasis
 * @date 2025-01-04
 */
@Service
public class VendingMachineServiceImpl implements IVendingMachineService 
{
    @Autowired
    private VendingMachineMapper vendingMachineMapper;

    /**
     * 查询Vending Machine Information
     * 
     * @param id Vending Machine Information主键
     * @return Vending Machine Information
     */
    @Override
    public VendingMachine selectVendingMachineById(Long id)
    {
        return vendingMachineMapper.selectVendingMachineById(id);
    }

    /**
     * 查询Vending Machine Information列表
     * 
     * @param vendingMachine Vending Machine Information
     * @return Vending Machine Information
     */
    @Override
    public List<VendingMachine> selectVendingMachineList(VendingMachine vendingMachine)
    {
        return vendingMachineMapper.selectVendingMachineList(vendingMachine);
    }

    /**
     * 新增Vending Machine Information
     * 
     * @param vendingMachine Vending Machine Information
     * @return 结果
     */
    @Override
    public int insertVendingMachine(VendingMachine vendingMachine)
    {
        vendingMachine.setCreateTime(DateUtils.getNowDate());
        return vendingMachineMapper.insertVendingMachine(vendingMachine);
    }

    /**
     * 修改Vending Machine Information
     * 
     * @param vendingMachine Vending Machine Information
     * @return 结果
     */
    @Override
    public int updateVendingMachine(VendingMachine vendingMachine)
    {
        vendingMachine.setUpdateTime(DateUtils.getNowDate());
        return vendingMachineMapper.updateVendingMachine(vendingMachine);
    }

    /**
     * 批量删除Vending Machine Information
     * 
     * @param ids 需要删除的Vending Machine Information主键
     * @return 结果
     */
    @Override
    public int deleteVendingMachineByIds(Long[] ids)
    {
        return vendingMachineMapper.deleteVendingMachineByIds(ids);
    }

    /**
     * 删除Vending Machine Information信息
     * 
     * @param id Vending Machine Information主键
     * @return 结果
     */
    @Override
    public int deleteVendingMachineById(Long id)
    {
        return vendingMachineMapper.deleteVendingMachineById(id);
    }
}
