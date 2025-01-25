package oasis.vend.manage.service;

import java.util.List;
import oasis.vend.manage.domain.VendingMachine;

/**
 * Vending Machine ManageService接口
 * 
 * @author oasis
 * @date 2025-01-07
 */
public interface IVendingMachineService 
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
     * 批量删除Vending Machine Manage
     * 
     * @param ids 需要删除的Vending Machine Manage主键集合
     * @return 结果
     */
    public int deleteVendingMachineByIds(Long[] ids);

    /**
     * 删除Vending Machine Manage信息
     * 
     * @param id Vending Machine Manage主键
     * @return 结果
     */
    public int deleteVendingMachineById(Long id);

    /**
     * query vending machine by inner code
     * @param innerCode
     * @return
     */
    public VendingMachine selectVendingMachineByInnerCode(String innerCode);
}
