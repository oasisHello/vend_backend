package oasis.vend.manage.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import oasis.vend.common.annotation.Excel;
import oasis.vend.common.core.domain.BaseEntity;

/**
 * location对象 location
 * 
 * @author ruoyi
 * @date 2024-12-23
 */
public class Location extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** name */
    @Excel(name = "name")
    private String name;

    /** address */
    @Excel(name = "address")
    private String address;

    /** address */
    @Excel(name = "address")
    private Long businessArea;

    /** region_id */
    @Excel(name = "region_id")
    private Long regionId;

    /** vendor_id */
    @Excel(name = "vendor_id")
    private Long vendorId;

    /** created_time */
    private Date createdTime;

    /** modified_time */
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
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setBusinessArea(Long businessArea) 
    {
        this.businessArea = businessArea;
    }

    public Long getBusinessArea() 
    {
        return businessArea;
    }
    public void setRegionId(Long regionId) 
    {
        this.regionId = regionId;
    }

    public Long getRegionId() 
    {
        return regionId;
    }
    public void setVendorId(Long vendorId) 
    {
        this.vendorId = vendorId;
    }

    public Long getVendorId() 
    {
        return vendorId;
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
            .append("address", getAddress())
            .append("businessArea", getBusinessArea())
            .append("regionId", getRegionId())
            .append("vendorId", getVendorId())
            .append("createdTime", getCreatedTime())
            .append("modifiedTime", getModifiedTime())
            .append("remark", getRemark())
            .append("createdBy", getCreatedBy())
            .append("modifiedBy", getModifiedBy())
            .toString();
    }
}
