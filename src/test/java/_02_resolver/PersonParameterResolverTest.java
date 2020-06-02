package _02_resolver;

import model.PersonModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(PersonResolver.class)
class PersonParameterResolverTest {

    @Test
    @DisplayName("should create invalid person model")
    void shouldBeInvalidPerson(@Invalid PersonModel person) {
        assertAll(
                () -> assertEquals("Invalid", person.getUsername()),
                () -> assertEquals("Invalid", person.getLastName()),
                () -> assertFalse(person.isVacation())
        );
    }

    @Test
    @DisplayName("should create valid person model")
    void shouldBeRealPerson(PersonModel person) {
        assertAll(
                () -> assertEquals("Micky", person.getUsername()),
                () -> assertFalse(person.isVacation())
        );
    }

    @Test
    @DisplayName("should create person model on vacation")
    void shouldBeOnVacationPerson(@WithVacation PersonModel person) {
        assertAll(
                () -> assertEquals("Micky", person.getUsername()),
                () -> assertTrue(person.isVacation())
        );
    }
}
