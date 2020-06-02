package _02_resolver;

import model.PersonModel;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;

public class PersonResolver implements ParameterResolver {

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return parameterContext.getParameter().getType() == PersonModel.class;
    }

    @Override
    public PersonModel resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        if (parameterContext.isAnnotated(Invalid.class))
            return new PersonModel().toBuilder()
                    .username("Invalid")
                    .lastName("Invalid")
                    .build();

        else if (parameterContext.isAnnotated(WithVacation.class))
            return new PersonModel().toBuilder()
                    .vacation(true)
                    .build();

        return new PersonModel().toBuilder().build();
    }
}
