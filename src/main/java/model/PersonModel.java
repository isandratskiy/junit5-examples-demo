package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

import static java.time.LocalDate.*;

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
	@JsonProperty("personStatus")
	private String personStatus = "ACTIVE";

	@Builder.Default
	@JsonProperty("lastTimeActive")
	private String lastTimeActive = "15-10-2019";

	@Builder.Default
	@JsonProperty("birthDate")
	private LocalDate birthDate = parse("1965-12-12");
}