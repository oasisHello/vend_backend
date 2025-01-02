package oasis.vend.manage.service;

import java.util.List;
import oasis.vend.manage.domain.emp;

/**
 * Employee ListService接口
 * 
 * @author oasis
 * @date 2024-12-31
 */
public interface IempService 
{
    /**
     * 查询Employee List
     * 
     * @param id Employee List主键
     * @return Employee List
     */
    public emp selectempById(Long id);

    /**
     * 查询Employee List列表
     * 
     * @param emp Employee List
     * @return Employee List集合
     */
    public List<emp> selectempList(emp emp);

    /**
     * 新增Employee List
     * 
     * @param emp Employee List
     * @return 结果
     */
    public int insertemp(emp emp);

    /**
     * 修改Employee List
     * 
     * @param emp Employee List
     * @return 结果
     */
    public int updateemp(emp emp);

    /**
     * 批量删除Employee List
     * 
     * @param ids 需要删除的Employee List主键集合
     * @return 结果
     */
    public int deleteempByIds(Long[] ids);

    /**
     * 删除Employee List信息
     * 
     * @param id Employee List主键
     * @return 结果
     */
    public int deleteempById(Long id);
}
