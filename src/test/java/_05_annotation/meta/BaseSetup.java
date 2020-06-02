package _05_annotation.meta;

import _03_lifecycle_callback.PersonResolver;
import _03_lifecycle_callback.SetupPersonVacationExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE})
@Retention(RUNTIME)
@ExtendWith({SetupPersonVacationExtension.class, PersonResolver.class})
public @interface BaseSetup {
}
