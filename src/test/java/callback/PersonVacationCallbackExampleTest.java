package callback;

import model.PersonModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({SetupPersonVacationExtension.class, VacationPersonResolver.class})
@DisplayName("Person creation on before callback test example")
class PersonVacationCallbackExampleTest {
    @Test
    @DisplayName("should create with valid credentials")
    void shouldCreateWithValidCredentials(PersonModel person) {
        assertAll(
                () -> assertEquals("Sandro", person.getFirstName()),
                () -> assertEquals("Botticelli", person.getLastName())
        );
    }

    @Test
    @DisplayName("should create person with vacation")
    void shouldCreatePersonWithVacation(PersonModel person) {
        assertTrue(person.isVacation());
    }
}
