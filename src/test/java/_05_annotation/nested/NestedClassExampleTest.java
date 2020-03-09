package _05_annotation.nested;

import com.google.common.flogger.FluentLogger;
import model.PersonModel;
import org.junit.jupiter.api.*;

import static com.google.common.flogger.FluentLogger.forEnclosingClass;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Nested with instance lifecycle tests example")
class NestedClassExampleTest {
    private static final FluentLogger log = forEnclosingClass();
    private PersonModel person;

    @BeforeEach
    void arrangeParentClass() {
        this.person = new PersonModel().toBuilder().build();
        log.atInfo().log("PARENT CLASS BEFORE EACH ==> " + person.toString());
    }

    @Nested
    class FirstNested {
        @BeforeEach
        void setupFirstNested() {
            person.setFirstName("Valinor");
            log.atInfo().log("FIRST NESTED BEFORE EACH ==> " + person.toString());
        }

        @Test
        void firstNestedEqualTest() {
            assertEquals("Valinor", person.getFirstName());
        }

        @Test
        void firstNestedNotEqualTest() {
            assertEquals("Valinor", person.getFirstName());
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class SecondNested {
        private PersonModel person;

        @BeforeAll
        void arrangeSecondNested() {
            this.person = new PersonModel().toBuilder().build();
            log.atInfo().log("SECOND NESTED BEFORE ALL ==> " + person.toString());
        }

        @BeforeEach
        void setupSecondNested() {
            person.setFirstName("Sauron");
            log.atInfo().log("SECOND NESTED BEFORE EACH ==> " + person.toString());
        }

        @Test
        void secondNestedEqualTest() {
            assertEquals("Sauron", person.getFirstName());
        }

        @Test
        void secondNestedNotEqualTest() {
            assertEquals("Sauron", person.getFirstName());
        }
    }
}
