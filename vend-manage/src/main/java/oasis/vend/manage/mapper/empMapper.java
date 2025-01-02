package oasis.vend.manage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Update;

import io.lettuce.core.dynamic.annotation.Param;
import oasis.vend.manage.domain.emp;

/**
 * Employee ListMapper接口
 * 
 * @author oasis
 * @date 2024-12-31
 */
public interface empMapper 
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
     * 删除Employee List
     * 
     * @param id Employee List主键
     * @return 结果
     */
    public int deleteempById(Long id);

    /**
     * 批量删除Employee List
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteempByIds(Long[] ids);
    
    /**
     *  update employee role name by role id
     *  
     */
    @Update("UPDATE tb_emp SET role_name = #{arg1} WHERE role_id = #{arg0}")
    public int updateRoleNameByRoleID(Long roleId, String roleName);
}
