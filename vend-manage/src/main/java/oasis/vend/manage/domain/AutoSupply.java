package oasis.vend.manage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import oasis.vend.common.annotation.Excel;
import oasis.vend.common.core.domain.BaseEntity;

/**
 * auto supply对象 auto_supply
 * 
 * @author oasis
 * @date 2025-01-20
 */
public class AutoSupply extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** alert */
    @Excel(name = "alert")
    private Long alertValue;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAlertValue(Long alertValue) 
    {
        this.alertValue = alertValue;
    }

    public Long getAlertValue() 
    {
        return alertValue;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("alertValue", getAlertValue())
            .toString();
    }
}
