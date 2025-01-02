package oasis.vend.manage.service;

import java.util.List;
import oasis.vend.manage.domain.Role;

/**
 * Role ListService接口
 * 
 * @author oasis
 * @date 2024-12-31
 */
public interface IRoleService 
{
    /**
     * 查询Role List
     * 
     * @param roleId Role List主键
     * @return Role List
     */
    public Role selectRoleByRoleId(Long roleId);

    /**
     * 查询Role List列表
     * 
     * @param role Role List
     * @return Role List集合
     */
    public List<Role> selectRoleList(Role role);

    /**
     * 新增Role List
     * 
     * @param role Role List
     * @return 结果
     */
    public int insertRole(Role role);

    /**
     * 修改Role List
     * 
     * @param role Role List
     * @return 结果
     */
    public int updateRole(Role role);

    /**
     * 批量删除Role List
     * 
     * @param roleIds 需要删除的Role List主键集合
     * @return 结果
     */
    public int deleteRoleByRoleIds(Long[] roleIds);

    /**
     * 删除Role List信息
     * 
     * @param roleId Role List主键
     * @return 结果
     */
    public int deleteRoleByRoleId(Long roleId);
}
