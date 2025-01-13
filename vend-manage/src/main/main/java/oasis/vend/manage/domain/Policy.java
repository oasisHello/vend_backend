package oasis.vend.manage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import oasis.vend.common.annotation.Excel;
import oasis.vend.common.core.domain.BaseEntity;

/**
 * Policy Information对象 policy
 * 
 * @author oasis
 * @date 2025-01-13
 */
public class Policy extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** Policy ID */
    private Long id;

    /** Policy Name */
    @Excel(name = "Policy Name")
    private String name;

    /** Policy Code */
    @Excel(name = "Policy Code")
    private String code;

    /** Discount Rate */
    @Excel(name = "Discount Rate")
    private Long discount;

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
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setDiscount(Long discount) 
    {
        this.discount = discount;
    }

    public Long getDiscount() 
    {
        return discount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("code", getCode())
            .append("discount", getDiscount())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
