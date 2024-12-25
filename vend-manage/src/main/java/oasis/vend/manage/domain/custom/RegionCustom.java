package oasis.vend.manage.domain.custom;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import oasis.vend.manage.domain.Region;
@Data
public class RegionCustom extends Region {

	// location count
	@JsonProperty("locationCount") // to make sure locationCount is returned in the response.
	private Integer locationCount;
}
