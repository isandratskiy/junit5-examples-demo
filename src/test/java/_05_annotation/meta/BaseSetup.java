package _05_annotation.meta;

import _02_callback.SetupPersonVacationExtension;
import _02_callback.VacationPersonResolver;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

@Target({TYPE})
@Retention(RUNTIME)
@Execution(CONCURRENT)
@ExtendWith({SetupPersonVacationExtension.class, VacationPersonResolver.class})
public @interface BaseSetup {

}
