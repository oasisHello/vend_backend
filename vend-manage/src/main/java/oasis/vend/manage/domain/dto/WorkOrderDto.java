package oasis.vend.manage.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * work order(data transmission object)
 */
@Data
public class WorkOrderDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("createType")
    private Long createType;
    @JsonProperty("vmInnerCode")
    private String vmInnerCode;
    @JsonProperty("regionId")
    private Long regionId;
    @JsonProperty("userId")
    private Long userId;
    @JsonProperty("assignorId")
    private Long assignorId;
    @JsonProperty("typeId")
    private Long typeId;
    @JsonProperty("description")
    private String description;

    // valid when work order type is operation
    @JsonProperty("details") // NOTE: should be consistent the frontend like form to render or receive data.
    private List<OperationDetailDto> details;
}
