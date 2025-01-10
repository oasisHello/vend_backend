package oasis.vend.manage.domain.custom;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import oasis.vend.manage.domain.Location;
import oasis.vend.manage.domain.Region;
import oasis.vend.manage.domain.Vendor;

@Data
public class LocationCustom extends Location {
	// Vending machine count
	@JsonProperty("vmCount") // Ensure that the data is successfully sent from the backend to the frontend
	private Integer vmCount;
	@JsonProperty("region")
	private Region region;
	@JsonProperty("vendor")
	private Vendor vendor;
}
