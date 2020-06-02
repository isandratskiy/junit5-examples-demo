package _03_lifecycle_callback;

import model.PersonModel;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;

import static org.junit.jupiter.api.extension.ExtensionContext.Namespace.GLOBAL;

public class PersonResolver implements ParameterResolver {
    private static final String PERSON_KEY = "person";

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return parameterContext.getParameter().getType() == PersonModel.class;
    }

    @Override
    public PersonModel resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return extensionContext.getStore(GLOBAL).get(PERSON_KEY, PersonModel.class);
    }
}
