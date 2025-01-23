package oasis.vend.manage.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OperationDetailDto {
    @JsonProperty("aisleCode")
    private String aisleCode;
    @JsonProperty("availableCapacity")
    private Long availableCapacity;
    @JsonProperty("goodsId")
    private Long goodsId;
    @JsonProperty("goodsName")
    public  String goodsName;
    @JsonProperty("goodsImage")
    public  String goodsImage;
}
