package example._04_parameterized._03_arguments_aggregator;

import model.PersonModel;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

import java.time.LocalDate;

public class PersonAggregator implements ArgumentsAggregator {

    @Override
    public PersonModel aggregateArguments(ArgumentsAccessor arguments, ParameterContext context) {
        if (context.getParameter().getType().isAssignableFrom(PersonModel.class)
                && context.isAnnotated(CsvSourcePerson.class))
            return new PersonModel()
                    .toBuilder()
                    .firstName(arguments.getString(0))
                    .lastName(arguments.getString(1))
                    .birthDate(arguments.get(2, LocalDate.class))
                    .build();
        else throw new ArgumentsAggregationException("Not found assignable parameter with annotation @CsvSourcePerson");
    }
}
