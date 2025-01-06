package oasis.vend.manage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import oasis.vend.common.annotation.Excel;
import oasis.vend.common.core.domain.BaseEntity;

/**
 * Employee List对象 tb_emp
 * 
 * @author oasis
 * @date 2024-12-31
 */
public class emp extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** Primary key for employee */
    private Long id;

    /** Employee name */
    @Excel(name = "Employee name")
    private String userName;

    /** Associated region ID */
    private Long regionId;

    /** Region name */
    @Excel(name = "Region name")
    private String regionName;

    /** Associated role ID */
    private Long roleId;

    /** Role code */
    @Excel(name = "Role code")
    private String roleCode;

    /** Role name */
    @Excel(name = "Role name")
    private String roleName;

    /** Mobile phone number */
    @Excel(name = "Mobile phone number")
    private String mobile;

    /** Profile picture */
    private String image;

    /** Status (1 active, 0 inactive) */
    private Integer status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setRegionId(Long regionId) 
    {
        this.regionId = regionId;
    }

    public Long getRegionId() 
    {
        return regionId;
    }
    public void setRegionName(String regionName) 
    {
        this.regionName = regionName;
    }

    public String getRegionName() 
    {
        return regionName;
    }
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
    public void setMobile(String mobile) 
    {
        this.mobile = mobile;
    }

    public String getMobile() 
    {
        return mobile;
    }
    public void setImage(String image) 
    {
        this.image = image;
    }

    public String getImage() 
    {
        return image;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userName", getUserName())
            .append("regionId", getRegionId())
            .append("regionName", getRegionName())
            .append("roleId", getRoleId())
            .append("roleCode", getRoleCode())
            .append("roleName", getRoleName())
            .append("mobile", getMobile())
            .append("image", getImage())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
