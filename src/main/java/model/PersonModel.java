package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class PersonModel {
	@Builder.Default
	@JsonProperty("firstName")
	private String firstName = "defaultName";

	@Builder.Default
	@JsonProperty("lastName")
	private String lastName = "defaultLastName";

	@Builder.Default
	@JsonProperty("password")
	private String password = "defaultPass";

	@Builder.Default
	@JsonProperty("email")
	private String email = "testmick@mick.com";

	@Builder.Default
	@JsonProperty("user")
	private String username = "Micky";

	@Builder.Default
	@JsonProperty("vacation")
	private boolean vacation = false;

	@Builder.Default
	@JsonProperty("userStatus")
	private String userStatus = "ACTIVE";

	@Builder.Default
	@JsonProperty("lastTimeActive")
	private String lastTimeActive = "15.10.2019";
}