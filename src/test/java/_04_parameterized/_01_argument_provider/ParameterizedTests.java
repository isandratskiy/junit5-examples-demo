package _04_parameterized._01_argument_provider;

import model.PersonModel;
import org.junit.jupiter.params.ParameterizedTest;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ParameterizedTests {

	@JsonSource("src/test/resources/person-test-data.json")
	@ParameterizedTest(name = "#{index} should verify person as {0}")
	void customParameterizedTest(PersonModel person) {
		assertNotEquals("baz", person.getFirstName());
		assertNotEquals(14, person.getPassword());
	}
}