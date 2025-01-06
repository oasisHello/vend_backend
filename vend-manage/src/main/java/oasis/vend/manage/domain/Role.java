package oasis.vend.manage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import oasis.vend.common.annotation.Excel;
import oasis.vend.common.core.domain.BaseEntity;

/**
 * Role List对象 tb_role
 * 
 * @author oasis
 * @date 2024-12-31
 */
public class Role extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** Primary key for role */
    private Long roleId;

    /** Role code */
    @Excel(name = "Role code")
    private String roleCode;

    /** Role name */
    @Excel(name = "Role name")
    private String roleName;

    public void setRoleId(Long roleId) 
    {
        this.roleId = roleId;
    }

    public Long getRoleId() 
    {
        return roleId;
    }
    public void setRoleCode(String roleCode) 
    {
        this.roleCode = roleCode;
    }

    public String getRoleCode() 
    {
        return roleCode;
    }
    public void setRoleName(String roleName) 
    {
        this.roleName = roleName;
    }

    public String getRoleName() 
    {
        return roleName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("roleId", getRoleId())
            .append("roleCode", getRoleCode())
            .append("roleName", getRoleName())
            .toString();
    }
}
