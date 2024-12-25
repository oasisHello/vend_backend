package oasis.vend.manage.domain.custom;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import oasis.vend.manage.domain.Vendor;

@Data
public class VendorCustom extends Vendor{
	@JsonProperty("locationCount") // to make sure locationCount is returned in the response.
	private Integer locationCount;
}
