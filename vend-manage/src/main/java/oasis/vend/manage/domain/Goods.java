package oasis.vend.manage.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import oasis.vend.common.annotation.Excel;
import oasis.vend.common.core.domain.BaseEntity;

/**
 * Product table对象 goods
 * 
 * @author oasis
 * @date 2025-01-14
 */
public class Goods extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** Product ID */
    private Long id;

    /** Name */
    @Excel(name = "Name")
    private String name;

    /** Code */
    @Excel(name = "Code")
    private String code;

    /** Image URL */
    @Excel(name = "Image URL")
    private String image;

    /** Brand name */
    @Excel(name = "Brand name")
    private String brandName;

    /** Unit */
    @Excel(name = "Unit")
    private String unit;

    /** Price */
    @Excel(name = "Price")
    private BigDecimal price;

    /** Product type ID */
    @Excel(name = "Product type ID")
    private Long goodsTypeId;

    /** Discount flag */
    private Integer isDiscount;

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
    public void setImage(String image) 
    {
        this.image = image;
    }

    public String getImage() 
    {
        return image;
    }
    public void setBrandName(String brandName) 
    {
        this.brandName = brandName;
    }

    public String getBrandName() 
    {
        return brandName;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setGoodsTypeId(Long goodsTypeId) 
    {
        this.goodsTypeId = goodsTypeId;
    }

    public Long getGoodsTypeId() 
    {
        return goodsTypeId;
    }
    public void setIsDiscount(Integer isDiscount) 
    {
        this.isDiscount = isDiscount;
    }

    public Integer getIsDiscount() 
    {
        return isDiscount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("code", getCode())
            .append("image", getImage())
            .append("brandName", getBrandName())
            .append("unit", getUnit())
            .append("price", getPrice())
            .append("goodsTypeId", getGoodsTypeId())
            .append("isDiscount", getIsDiscount())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
