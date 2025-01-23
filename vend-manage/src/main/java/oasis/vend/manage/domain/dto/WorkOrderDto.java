package oasis.vend.manage.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * work order(data transmission object)
 */
public class WorkOrderDto {
    @JsonProperty("createType")
    private Long createType;
    @JsonProperty("vmInnerCode")
    private String vmInnerCode;
    @JsonProperty("userId")
    private Long userId;
    @JsonProperty("assignorId")
    private Long assignorId;
    @JsonProperty("typeId")
    private Long typeId;
    @JsonProperty("remark")
    private String remark;
    // valid when work order type is operation
    @JsonProperty("operation details")
    private List<OperationDetailDto> details;
}
