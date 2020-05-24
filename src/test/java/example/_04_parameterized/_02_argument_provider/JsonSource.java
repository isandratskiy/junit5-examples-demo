package example._04_parameterized._02_argument_provider;

import org.junit.jupiter.params.provider.ArgumentsSource;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(METHOD)
@ArgumentsSource(JsonArgumentProvider.class)
public @interface JsonSource {
	String value();
}
