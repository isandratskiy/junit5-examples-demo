package example._03_lifecycle_callback;

import lombok.val;
import model.PersonModel;
import org.junit.jupiter.api.extension.*;
import service.PersonService;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.extension.ExtensionContext.Namespace.*;

public class SetupPersonVacationExtension implements BeforeAllCallback, AfterAllCallback, BeforeEachCallback, AfterEachCallback, ParameterResolver {
    private static final String PERSON_KEY = "person";

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return parameterContext.getParameter().getType() == PersonModel.class;
    }

    @Override
    public PersonModel resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return extensionContext.getStore(GLOBAL).get(PERSON_KEY, PersonModel.class);
    }

    @Override
    public void beforeAll(ExtensionContext context) {
        val person = new PersonModel()
                .toBuilder()
                .firstName("Sandro")
                .lastName("Botticelli")
                .build();
        context.getStore(GLOBAL).put(PERSON_KEY, person);
    }

    @Override
    public void beforeEach(ExtensionContext context) {
        val person = context.getStore(GLOBAL).get(PERSON_KEY, PersonModel.class);
        val service = new PersonService(person);
        service.takeVacation();
    }

    @Override
    public void afterEach(ExtensionContext context) {
        val person = context.getStore(GLOBAL).get(PERSON_KEY, PersonModel.class);
        val service = new PersonService(person);
        service.completeVacation();
    }

    @Override
    public void afterAll(ExtensionContext context) {
        val person = context.getStore(GLOBAL).get(PERSON_KEY, PersonModel.class);
        assertFalse(person.isVacation(), "Person on vacation!");
    }
}
