package oasis.vend.manage.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import oasis.vend.common.annotation.Excel;
import oasis.vend.common.core.domain.BaseEntity;

/**
 * Vending Machine Information对象 tb_vending_machine
 * 
 * @author oasis
 * @date 2025-01-04
 */
public class VendingMachine extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** Code */
    @Excel(name = "Code")
    private String innerCode;

    /** Capacity */
    private Long aisleMaxCapacity;

    /** Node */
    private Long nodeId;

    /** Address */
    @Excel(name = "Address")
    private String addr;

    /** Last Supply Time */
    private Date lastSupplyTime;

    /** Business Type */
    private Long businessType;

    /** Region ID */
    private Long regionId;

    /** Partner ID */
    @Excel(name = "Partner ID")
    private Long partnerId;

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
    public void setNodeId(Long nodeId) 
    {
        this.nodeId = nodeId;
    }

    public Long getNodeId() 
    {
        return nodeId;
    }
    public void setAddr(String addr) 
    {
        this.addr = addr;
    }

    public String getAddr() 
    {
        return addr;
    }
    public void setLastSupplyTime(Date lastSupplyTime) 
    {
        this.lastSupplyTime = lastSupplyTime;
    }

    public Date getLastSupplyTime() 
    {
        return lastSupplyTime;
    }
    public void setBusinessType(Long businessType) 
    {
        this.businessType = businessType;
    }

    public Long getBusinessType() 
    {
        return businessType;
    }
    public void setRegionId(Long regionId) 
    {
        this.regionId = regionId;
    }

    public Long getRegionId() 
    {
        return regionId;
    }
    public void setPartnerId(Long partnerId) 
    {
        this.partnerId = partnerId;
    }

    public Long getPartnerId() 
    {
        return partnerId;
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
            .append("nodeId", getNodeId())
            .append("addr", getAddr())
            .append("lastSupplyTime", getLastSupplyTime())
            .append("businessType", getBusinessType())
            .append("regionId", getRegionId())
            .append("partnerId", getPartnerId())
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
