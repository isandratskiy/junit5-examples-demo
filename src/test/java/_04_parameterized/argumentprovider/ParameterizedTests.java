package _04_parameterized.argumentprovider;

import model.PersonModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DisplayName("Parametrized @JsonSource test example")
class ParameterizedTests {

	@DisplayName("custom parametrized person test")
	@JsonSource("src/test/resources/person-test-data.json")
	@ParameterizedTest(name = "#{index} - should check person = {0}")
	void customParameterizedTest(PersonModel person) {
		assertNotEquals("baz", person.getFirstName());
		assertNotEquals(14, person.getPassword());
	}
}