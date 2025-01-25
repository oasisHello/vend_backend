package oasis.vend.manage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import oasis.vend.common.annotation.Excel;
import oasis.vend.common.core.domain.BaseEntity;

/**
 * Operation detail table对象 operation_detail
 * 
 * @author oasis
 * @date 2025-01-20
 */
public class OperationDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** Order ID */
    @Excel(name = "Order ID")
    private Long orderId;

    /** Aisle code */
    @Excel(name = "Aisle code")
    private String aisleCode;

    /** Available capacity */
    @Excel(name = "Available capacity")
    private Long availableCapacity;

    /** Goods ID */
    @Excel(name = "Goods ID")
    private Long goodsId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setAisleCode(String aisleCode) 
    {
        this.aisleCode = aisleCode;
    }

    public String getAisleCode() 
    {
        return aisleCode;
    }

    public Long getAvailableCapacity()
    {
        return availableCapacity;
    }
    public void setGoodsId(Long goodsId) 
    {
        this.goodsId = goodsId;
    }

    public Long getGoodsId() 
    {
        return goodsId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderId", getOrderId())
            .append("aisleCode", getAisleCode())
            .append("availableCapacity", getAvailableCapacity())
            .append("goodsId", getGoodsId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
