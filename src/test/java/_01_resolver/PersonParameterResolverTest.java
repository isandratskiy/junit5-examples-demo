package _01_resolver;

import model.PersonModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(PersonResolver.class)
class PersonParameterResolverTest {
    @Test
    @DisplayName("should be invalid person model")
    void shouldBeInvalidPersonModel(@InvalidUser PersonModel person) {
        assertAll(
                () -> assertEquals("Invalid", person.getUsername()),
                () -> assertEquals("Invalid", person.getLastName()),
                () -> assertEquals("Invalid", person.getPassword())
        );
    }

    @Test
    @DisplayName("should be real person model")
    void shouldBeRealUserModel(PersonModel person) {
        assertEquals("Micky", person.getUsername());
    }
}
