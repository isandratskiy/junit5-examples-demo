package _03_lifecycle_callback;

import _05_annotation.meta.BaseSetup;
import model.PersonModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

//@BaseSetup
@ExtendWith({SetupPersonVacationExtension.class, PersonResolver.class})
class PersonVacationCallbackTest {

    @Test
    @DisplayName("should create person with valid credentials")
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
