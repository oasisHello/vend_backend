package oasis.vend.manage.mapper;

import java.util.List;
import oasis.vend.manage.domain.VendingMachine;

/**
 * Vending Machine InformationMapper接口
 * 
 * @author oasis
 * @date 2025-01-04
 */
public interface VendingMachineMapper 
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
     * 删除Vending Machine Information
     * 
     * @param id Vending Machine Information主键
     * @return 结果
     */
    public int deleteVendingMachineById(Long id);

    /**
     * 批量删除Vending Machine Information
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteVendingMachineByIds(Long[] ids);
}
