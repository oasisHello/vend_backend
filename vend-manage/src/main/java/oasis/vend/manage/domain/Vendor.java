package oasis.vend.manage.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import oasis.vend.common.annotation.Excel;
import oasis.vend.common.core.domain.BaseEntity;

/**
 * vendor对象 vendor
 * 
 * @author oasis
 * @date 2024-12-23
 */
public class Vendor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** name */
    @Excel(name = "name")
    private String name;

    /** contactor */
    @Excel(name = "contactor")
    private String contactor;

    /** phone */
    @Excel(name = "phone")
    private String phone;

    /** ratio */
    @Excel(name = "ratio")
    private BigDecimal ratio;

    /** acccount */
    @Excel(name = "acccount")
    private String account;

    /** password */
    private String password;

    /** created_date */
    private Date createdTime;

    /** modified_date */
    private Date modifiedTime;

    /** created_by */
    private String createdBy;

    /** modified_by */
    private String modifiedBy;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setContactor(String contactor) 
    {
        this.contactor = contactor;
    }

    public String getContactor() 
    {
        return contactor;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setRatio(BigDecimal ratio) 
    {
        this.ratio = ratio;
    }

    public BigDecimal getRatio() 
    {
        return ratio;
    }
    public void setAccount(String account) 
    {
        this.account = account;
    }

    public String getAccount() 
    {
        return account;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setCreatedTime(Date createdTime) 
    {
        this.createdTime = createdTime;
    }

    public Date getCreatedTime() 
    {
        return createdTime;
    }
    public void setModifiedTime(Date modifiedTime) 
    {
        this.modifiedTime = modifiedTime;
    }

    public Date getModifiedTime() 
    {
        return modifiedTime;
    }
    public void setCreatedBy(String createdBy) 
    {
        this.createdBy = createdBy;
    }

    public String getCreatedBy() 
    {
        return createdBy;
    }
    public void setModifiedBy(String modifiedBy) 
    {
        this.modifiedBy = modifiedBy;
    }

    public String getModifiedBy() 
    {
        return modifiedBy;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("contactor", getContactor())
            .append("phone", getPhone())
            .append("ratio", getRatio())
            .append("account", getAccount())
            .append("password", getPassword())
            .append("createdTime", getCreatedTime())
            .append("modifiedTime", getModifiedTime())
            .append("remark", getRemark())
            .append("createdBy", getCreatedBy())
            .append("modifiedBy", getModifiedBy())
            .toString();
    }
}
