package oasis.vend.manage.service;

import java.util.List;
import oasis.vend.manage.domain.VendingMachine;

/**
 * Vending Machine InformationService接口
 * 
 * @author oasis
 * @date 2025-01-04
 */
public interface IVendingMachineService 
{
    /**
     * 查询Vending Machine Information
     * 
     * @param id Vending Machine Information主键
     * @return Vending Machine Information
     */
    public VendingMachine selectVendingMachineById(Long id);

    /**
     * 查询Vending Machine Information列表
     * 
     * @param vendingMachine Vending Machine Information
     * @return Vending Machine Information集合
     */
    public List<VendingMachine> selectVendingMachineList(VendingMachine vendingMachine);

    /**
     * 新增Vending Machine Information
     * 
     * @param vendingMachine Vending Machine Information
     * @return 结果
     */
    public int insertVendingMachine(VendingMachine vendingMachine);

    /**
     * 修改Vending Machine Information
     * 
     * @param vendingMachine Vending Machine Information
     * @return 结果
     */
    public int updateVendingMachine(VendingMachine vendingMachine);

    /**
     * 批量删除Vending Machine Information
     * 
     * @param ids 需要删除的Vending Machine Information主键集合
     * @return 结果
     */
    public int deleteVendingMachineByIds(Long[] ids);

    /**
     * 删除Vending Machine Information信息
     * 
     * @param id Vending Machine Information主键
     * @return 结果
     */
    public int deleteVendingMachineById(Long id);
}
