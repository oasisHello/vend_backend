package oasis.vend.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oasis.vend.manage.mapper.RoleMapper;
import oasis.vend.manage.mapper.empMapper;
import oasis.vend.manage.domain.Role;
import oasis.vend.manage.service.IRoleService;

/**
 * Role ListService业务层处理
 * 
 * @author oasis
 * @date 2024-12-31
 */
@Service
public class RoleServiceImpl implements IRoleService 
{
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private empMapper employeeMapper;

    /**
     * 查询Role List
     * 
     * @param roleId Role List主键
     * @return Role List
     */
    @Override
    public Role selectRoleByRoleId(Long roleId)
    {
        return roleMapper.selectRoleByRoleId(roleId);
    }

    /**
     * 查询Role List列表
     * 
     * @param role Role List
     * @return Role List
     */
    @Override
    public List<Role> selectRoleList(Role role)
    {
        return roleMapper.selectRoleList(role);
    }

    /**
     * 新增Role List
     * 
     * @param role Role List
     * @return 结果
     */
    @Override
    public int insertRole(Role role)
    {
        return roleMapper.insertRole(role);
    }

    /**
     * 修改Role List
     * 
     * @param role Role List
     * @return 结果
     */
    @Transactional(rollbackFor=Exception.class)
    @Override
    public int updateRole(Role role)
    {
    	int result =roleMapper.updateRole(role);
    	// update employee's role name by id
    	//employeeMapper.updateRoleNameByRoleID(role.getRoleId(),role.getRoleName());
    	employeeMapper.updateRoleNameByRoleID(1L, "Administrator");
        return result;
    }

    /**
     * 批量删除Role List
     * 
     * @param roleIds 需要删除的Role List主键
     * @return 结果
     */
    @Override
    public int deleteRoleByRoleIds(Long[] roleIds)
    {
        return roleMapper.deleteRoleByRoleIds(roleIds);
    }

    /**
     * 删除Role List信息
     * 
     * @param roleId Role List主键
     * @return 结果
     */
    @Override
    public int deleteRoleByRoleId(Long roleId)
    {
        return roleMapper.deleteRoleByRoleId(roleId);
    }
}
