package _01_instance_processor;

import lombok.SneakyThrows;
import lombok.val;
import model.PersonModel;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;
import service.PersonService;

import static java.util.Arrays.*;

public class ServiceInjector implements TestInstancePostProcessor {

    @SneakyThrows
    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context) {
        val serviceField = stream(testInstance.getClass().getDeclaredFields())
                .filter(x -> x.getType().isAssignableFrom(PersonService.class))
                .findFirst()
                .orElseThrow(() -> new NoSuchFieldException("Not found PersonService.class field"));

        serviceField.setAccessible(true);
        serviceField.set(testInstance, new PersonService(
                new PersonModel()
                        .toBuilder()
                        .firstName("Magni")
                        .build()
        ));
    }
}