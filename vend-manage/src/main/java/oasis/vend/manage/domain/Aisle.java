package oasis.vend.manage.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import oasis.vend.common.annotation.Excel;
import oasis.vend.common.core.domain.BaseEntity;

/**
 * Aisle Information对象 aisle
 * 
 * @author oasis
 * @date 2025-01-07
 */
public class Aisle extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** Channel ID */
    private Long id;

    /** aisle Code */
    @Excel(name = "aisle Code")
    private String code;

    /** SKU ID */
    @Excel(name = "SKU ID")
    private Long skuId;

    /** Machine ID */
    @Excel(name = "Machine ID")
    private Long vmId;

    /** Inner Code */
    @Excel(name = "Inner Code")
    private String innerCode;

    /** Max Capacity */
    @Excel(name = "Max Capacity")
    private Long maxCapacity;

    /** Current Capacity */
    @Excel(name = "Current Capacity")
    private Long currentCapacity;

    /** Last Supply Time */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "Last Supply Time", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastSupplyTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setSkuId(Long skuId) 
    {
        this.skuId = skuId;
    }

    public Long getSkuId() 
    {
        return skuId;
    }
    public void setVmId(Long vmId) 
    {
        this.vmId = vmId;
    }

    public Long getVmId() 
    {
        return vmId;
    }
    public void setInnerCode(String innerCode) 
    {
        this.innerCode = innerCode;
    }

    public String getInnerCode() 
    {
        return innerCode;
    }
    public void setMaxCapacity(Long maxCapacity) 
    {
        this.maxCapacity = maxCapacity;
    }

    public Long getMaxCapacity() 
    {
        return maxCapacity;
    }
    public void setCurrentCapacity(Long currentCapacity) 
    {
        this.currentCapacity = currentCapacity;
    }

    public Long getCurrentCapacity() 
    {
        return currentCapacity;
    }
    public void setLastSupplyTime(Date lastSupplyTime) 
    {
        this.lastSupplyTime = lastSupplyTime;
    }

    public Date getLastSupplyTime() 
    {
        return lastSupplyTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("code", getCode())
            .append("skuId", getSkuId())
            .append("vmId", getVmId())
            .append("innerCode", getInnerCode())
            .append("maxCapacity", getMaxCapacity())
            .append("currentCapacity", getCurrentCapacity())
            .append("lastSupplyTime", getLastSupplyTime())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
