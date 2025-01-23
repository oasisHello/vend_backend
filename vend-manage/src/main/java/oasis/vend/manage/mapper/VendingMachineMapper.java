package oasis.vend.manage.mapper;

import java.util.List;
import oasis.vend.manage.domain.VendingMachine;

/**
 * Vending Machine ManageMapper接口
 * 
 * @author oasis
 * @date 2025-01-07
 */
public interface VendingMachineMapper 
{
    /**
     * 查询Vending Machine Manage
     * 
     * @param id Vending Machine Manage主键
     * @return Vending Machine Manage
     */
    public VendingMachine selectVendingMachineById(Long id);

    /**
     * 查询Vending Machine Manage列表
     * 
     * @param vendingMachine Vending Machine Manage
     * @return Vending Machine Manage集合
     */
    public List<VendingMachine> selectVendingMachineList(VendingMachine vendingMachine);

    /**
     * 新增Vending Machine Manage
     * 
     * @param vendingMachine Vending Machine Manage
     * @return 结果
     */
    public int insertVendingMachine(VendingMachine vendingMachine);

    /**
     * 修改Vending Machine Manage
     * 
     * @param vendingMachine Vending Machine Manage
     * @return 结果
     */
    public int updateVendingMachine(VendingMachine vendingMachine);

    /**
     * 删除Vending Machine Manage
     * 
     * @param id Vending Machine Manage主键
     * @return 结果
     */
    public int deleteVendingMachineById(Long id);

    /**
     * 批量删除Vending Machine Manage
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteVendingMachineByIds(Long[] ids);

    /**
     * query vending machine by inner code
     * @param innerCode
     * @return VendingMachine
     */
    public VendingMachine selectVendingMachineByInnerCode(String innerCode);
}
