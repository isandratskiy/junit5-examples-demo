package _04_parameterized._03_arguments_aggregator;

import model.PersonModel;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class PersonAggregatorTest {

    @CsvSource({
            "Jane, Doe, 1988-10-15",
            "John, Doe, 1987-10-11"
    })
    @CsvFileSource(resources = "/persons.csv")
    @ParameterizedTest(name = "#{index} should verify person with name: {0} and birthday: {2}")
    void testWithArgumentsAggregator(@CsvSourcePerson PersonModel person) {
        assertAll(
                () -> assertNotNull(person.getFirstName()),
                () -> assertNotNull(person.getLastName()),
                () -> assertNotNull(person.getLastTimeActive())
        );
    }
}
