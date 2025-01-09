package oasis.vend.manage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import oasis.vend.common.annotation.Excel;
import oasis.vend.common.core.domain.BaseEntity;

/**
 * Machine Types对象 vm_type
 * 
 * @author oasis
 * @date 2025-01-07
 */
public class VmType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** Type ID */
    private Long id;

    /** Type Name */
    @Excel(name = "Type Name")
    private String name;

    /** Code */
    @Excel(name = "Code")
    private String code;

    /** Image URL */
    @Excel(name = "Image URL")
    private String image;

    /** Number of Rows */
    @Excel(name = "Number of Rows")
    private Long rowCount;

    /** Number of Columns */
    @Excel(name = "Number of Columns")
    private Long colCount;

    /** Maximum Capacity per Aisle */
    @Excel(name = "Maximum Capacity per Aisle")
    private Long aisleMaxCapacity;

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
    public void setRowCount(Long rowCount) 
    {
        this.rowCount = rowCount;
    }

    public Long getRowCount() 
    {
        return rowCount;
    }
    public void setColCount(Long colCount) 
    {
        this.colCount = colCount;
    }

    public Long getColCount() 
    {
        return colCount;
    }
    public void setAisleMaxCapacity(Long aisleMaxCapacity) 
    {
        this.aisleMaxCapacity = aisleMaxCapacity;
    }

    public Long getAisleMaxCapacity() 
    {
        return aisleMaxCapacity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("code", getCode())
            .append("image", getImage())
            .append("rowCount", getRowCount())
            .append("colCount", getColCount())
            .append("aisleMaxCapacity", getAisleMaxCapacity())
            .toString();
    }
}
