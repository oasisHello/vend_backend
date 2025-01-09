package oasis.vend.manage.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import oasis.vend.common.annotation.Excel;
import oasis.vend.common.core.domain.BaseEntity;

/**
 * Vending Machine Manage对象 vending_machine
 * 
 * @author oasis
 * @date 2025-01-07
 */
public class VendingMachine extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** Machine ID */
    private Long id;

    /** Inner Code */
    @Excel(name = "Inner Code")
    private String innerCode;

    /** Max Capacity */
    private Long aisleMaxCapacity;

    /** Location ID */
    private Long locationId;

    /** Address */
    @Excel(name = "Address")
    private String address;

    /** Last Supply Time */
    private Date lastSupplyTime;

    /** Business Area */
    private Long businessArea;

    /** Region ID */
    private Long regionId;

    /** Vendor ID */
    @Excel(name = "Vendor ID")
    private Long vendorId;

    /** Type ID */
    @Excel(name = "Type ID")
    private Long vmTypeId;

    /** Machine Status */
    @Excel(name = "Machine Status")
    private String vmStatus;

    /** Running Status */
    private String runningStatus;

    /** Longitude */
    private Long longitude;

    /** Latitude */
    private Long latitude;

    /** Client ID */
    private Long clientId;

    /** Policy ID */
    private Long policyId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setInnerCode(String innerCode) 
    {
        this.innerCode = innerCode;
    }

    public String getInnerCode() 
    {
        return innerCode;
    }
    public void setAisleMaxCapacity(Long aisleMaxCapacity) 
    {
        this.aisleMaxCapacity = aisleMaxCapacity;
    }

    public Long getAisleMaxCapacity() 
    {
        return aisleMaxCapacity;
    }
    public void setLocationId(Long locationId) 
    {
        this.locationId = locationId;
    }

    public Long getLocationId() 
    {
        return locationId;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setLastSupplyTime(Date lastSupplyTime) 
    {
        this.lastSupplyTime = lastSupplyTime;
    }

    public Date getLastSupplyTime() 
    {
        return lastSupplyTime;
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
    public void setVmTypeId(Long vmTypeId) 
    {
        this.vmTypeId = vmTypeId;
    }

    public Long getVmTypeId() 
    {
        return vmTypeId;
    }
    public void setVmStatus(String vmStatus) 
    {
        this.vmStatus = vmStatus;
    }

    public String getVmStatus() 
    {
        return vmStatus;
    }
    public void setRunningStatus(String runningStatus) 
    {
        this.runningStatus = runningStatus;
    }

    public String getRunningStatus() 
    {
        return runningStatus;
    }
    public void setLongitude(Long longitude) 
    {
        this.longitude = longitude;
    }

    public Long getLongitude() 
    {
        return longitude;
    }
    public void setLatitude(Long latitude) 
    {
        this.latitude = latitude;
    }

    public Long getLatitude() 
    {
        return latitude;
    }
    public void setClientId(Long clientId) 
    {
        this.clientId = clientId;
    }

    public Long getClientId() 
    {
        return clientId;
    }
    public void setPolicyId(Long policyId) 
    {
        this.policyId = policyId;
    }

    public Long getPolicyId() 
    {
        return policyId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("innerCode", getInnerCode())
            .append("aisleMaxCapacity", getAisleMaxCapacity())
            .append("locationId", getLocationId())
            .append("address", getAddress())
            .append("lastSupplyTime", getLastSupplyTime())
            .append("businessArea", getBusinessArea())
            .append("regionId", getRegionId())
            .append("vendorId", getVendorId())
            .append("vmTypeId", getVmTypeId())
            .append("vmStatus", getVmStatus())
            .append("runningStatus", getRunningStatus())
            .append("longitude", getLongitude())
            .append("latitude", getLatitude())
            .append("clientId", getClientId())
            .append("policyId", getPolicyId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
