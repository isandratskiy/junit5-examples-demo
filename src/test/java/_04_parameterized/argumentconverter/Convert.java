package _04_parameterized.argumentconverter;

import org.junit.jupiter.params.converter.ConvertWith;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({PARAMETER})
@ConvertWith(PersonStatusArgumentConverter.class)
public @interface Convert {
}
