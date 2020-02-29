package model;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class PersonModel {
	@Builder.Default
	private String firstName = "defaultName";

	@Builder.Default
	private String lastName = "defaultLastName";

	@Builder.Default
	private String password = "defaultPass";

	@Builder.Default
	private String email = "testmick@mick.com";

	@Builder.Default
	private String username = "Micky";
}