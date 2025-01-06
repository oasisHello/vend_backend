package oasis.vend.manage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import oasis.vend.common.annotation.Excel;
import oasis.vend.common.core.domain.BaseEntity;

/**
 * Vending Machine Types对象 tb_vm_type
 * 
 * @author oasis
 * @date 2025-01-04
 */
public class VmType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** Name */
    @Excel(name = "Name")
    private String name;

    /** Model */
    @Excel(name = "Model")
    private String model;

    /** Image */
    @Excel(name = "Image")
    private String image;

    /** Rows */
    @Excel(name = "Rows")
    private Long vmRow;

    /** Columns */
    @Excel(name = "Columns")
    private Long vmCol;

    /** Max Capacity */
    @Excel(name = "Max Capacity")
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
    public void setModel(String model) 
    {
        this.model = model;
    }

    public String getModel() 
    {
        return model;
    }
    public void setImage(String image) 
    {
        this.image = image;
    }

    public String getImage() 
    {
        return image;
    }
    public void setVmRow(Long vmRow) 
    {
        this.vmRow = vmRow;
    }

    public Long getVmRow() 
    {
        return vmRow;
    }
    public void setVmCol(Long vmCol) 
    {
        this.vmCol = vmCol;
    }

    public Long getVmCol() 
    {
        return vmCol;
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
            .append("model", getModel())
            .append("image", getImage())
            .append("vmRow", getVmRow())
            .append("vmCol", getVmCol())
            .append("aisleMaxCapacity", getAisleMaxCapacity())
            .toString();
    }
}
