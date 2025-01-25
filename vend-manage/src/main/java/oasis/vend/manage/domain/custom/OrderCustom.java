package oasis.vend.manage.domain.custom;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import oasis.vend.manage.domain.Order;
import oasis.vend.manage.domain.OrderType;
@Data
public class OrderCustom extends Order {
    @JsonProperty("orderType")
    private OrderType orderType;
}
