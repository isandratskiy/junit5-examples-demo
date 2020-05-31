package example._04_parameterized._02_argument_converter;

import model.PersonModel;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static example._04_parameterized._02_argument_converter.StatusEnum.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

public class PersonArgumentConverterTest {

    @MethodSource("statusSource")
    @ParameterizedTest(name = "#{index} person with status {0} should have last active time as {1}")
    void canCreatePersonWithCustomName(@PersonConverter PersonModel person, String lastLogin) {
        assertEquals(lastLogin, person.getLastTimeActive());
    }

    private static Stream<Arguments> statusSource() {
        return Stream.of(
                of(ACTIVE, "15-02-2020"),
                of(DEACTIVATED, "11-11-2019"),
                of(HIDDEN, "18-01-2020")
        );
    }
}