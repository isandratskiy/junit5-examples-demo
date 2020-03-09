package _03_instance_processor;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import service.PersonService;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(PersonServiceInjector.class)
class ServiceInstancePostProcessorTest {
    PersonService service;

    @BeforeEach
    void arrange() {
        this.service.takeVacation();
    }

    @Test
    @DisplayName("should be real person model")
    void shouldBeRealUserModel() {
        val person = this.service.getPersonInformation();
        assertTrue(person.isVacation());
    }
}
