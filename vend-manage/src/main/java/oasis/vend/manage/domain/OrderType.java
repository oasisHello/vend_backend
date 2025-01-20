package oasis.vend.manage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import oasis.vend.common.annotation.Excel;
import oasis.vend.common.core.domain.BaseEntity;

/**
 * Order type table对象 order_type
 * 
 * @author oasis
 * @date 2025-01-20
 */
public class OrderType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** Order type name */
    @Excel(name = "Order type name")
    private String name;

    /** Parent type ID */
    @Excel(name = "Parent type ID")
    private Long parentType;

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
    public void setParentType(Long parentType) 
    {
        this.parentType = parentType;
    }

    public Long getParentType() 
    {
        return parentType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("parentType", getParentType())
            .toString();
    }
}
