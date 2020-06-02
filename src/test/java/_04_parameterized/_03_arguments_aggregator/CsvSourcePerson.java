package _04_parameterized._03_arguments_aggregator;

import org.junit.jupiter.params.aggregator.AggregateWith;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({PARAMETER})
@Retention(RUNTIME)
@AggregateWith(PersonAggregator.class)
public @interface CsvSourcePerson {
}
