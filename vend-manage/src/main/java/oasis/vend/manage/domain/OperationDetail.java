package oasis.vend.manage.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import oasis.vend.common.annotation.Excel;
import oasis.vend.common.core.domain.BaseEntity;

/**
 * Operation Detail Table Object (operation_detail)
 *
 * Represents the details of operations in the system.
 *
 * @author oasis
 * @date 2025-01-20
 */
@ApiModel(description = "Details about the operation")
public class OperationDetail extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** Unique identifier */
    @ApiModelProperty(value = "Unique identifier of the operation detail", example = "1")
    private Long id;

    /** Order identifier */
    @ApiModelProperty(value = "Identifier of the associated order", example = "12345")
    @Excel(name = "Order ID")
    private Long orderId;

    /** Code of the aisle */
    @ApiModelProperty(value = "Code of the aisle where the operation occurred", example = "A01")
    @Excel(name = "Aisle Code")
    private String aisleCode;

    /** Remaining capacity in the aisle */
    @ApiModelProperty(value = "Available capacity in the aisle", example = "50")
    @Excel(name = "Available Capacity")
    private Long availableCapacity;

    /** Identifier for the goods */
    @ApiModelProperty(value = "Identifier of the goods associated with the operation", example = "67890")
    @Excel(name = "Goods ID")
    private Long goodsId;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getAisleCode() {
        return aisleCode;
    }

    public void setAisleCode(String aisleCode) {
        this.aisleCode = aisleCode;
    }

    public Long getAvailableCapacity() {
        return availableCapacity;
    }

    public void setAvailableCapacity(Long availableCapacity) {
        this.availableCapacity = availableCapacity;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
