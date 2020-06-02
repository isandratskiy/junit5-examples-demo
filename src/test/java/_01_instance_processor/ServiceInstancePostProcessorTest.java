package _01_instance_processor;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import service.PersonService;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ServiceInjector.class)
class ServiceInstancePostProcessorTest {

    /*@RegisterExtension
    ServiceInjector injector = new ServiceInjector();*/

    PersonService service;

    @BeforeEach
    void arrange() {
        this.service.takeVacation();
    }

    @Test
    @DisplayName("should create person on vacation")
    void shouldBeRealUserModel() {
        val person = this.service.getPersonInformation();
        assertTrue(person.isVacation());
    }
}
