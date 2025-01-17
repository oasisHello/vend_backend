package oasis.vend.manage.domain.custom;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import oasis.vend.manage.domain.Aisle;
import oasis.vend.manage.domain.Goods;

/**
 * customization of aisle
 */
@Data
public class AisleCustom extends Aisle {
    @JsonProperty("goods")
    private Goods goods;
}
