package example._04_parameterized;

import lombok.val;
import model.PersonModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

@DisplayName("Parametrized test example")
class ParameterizedMethodSourceTest {

    @MethodSource("nameProvider")
    //@MethodSource("_04_parameterized.NameProvider#nameProvider")
    @ParameterizedTest(name = "#{index} should create person with name: {0}")
    void canCreatePersonWithCustomName(String name) {
        val person = new PersonModel();
        person.setFirstName(name);
        assertEquals(person.getFirstName(), name);
    }

    private static Stream<Arguments> nameProvider() {
        return Stream.of(
                of("Bilbo"),
                of("Frodo"),
                of("Dúnadan"),
                of("Telcontar"),
                of("Thorongil"),
                of("Elrond")
        );
    }
}