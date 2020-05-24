package example._04_parameterized;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

public class PersonNameProvider {
    public static Stream<Arguments> nameProvider() {
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
