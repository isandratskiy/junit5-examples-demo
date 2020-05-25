package example._05_annotation.nested;

import com.google.common.flogger.FluentLogger;
import model.PersonModel;
import org.junit.jupiter.api.*;

import static com.google.common.flogger.FluentLogger.forEnclosingClass;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.*;

@DisplayName("Nested tests with instance lifecycle")
class NestedClassExampleTest {
    private final FluentLogger log = forEnclosingClass();
    private PersonModel person;

    @BeforeEach
    void arrangeParentClass() {
        this.person = new PersonModel().toBuilder().build();
        log.atInfo().log("PARENT CLASS BEFORE EACH ==> " + person.toString());
    }

    @Nested
    @DisplayName("when default instance")
    class FirstNested {

        @BeforeEach
        void setupFirstNested() {
            person.setFirstName("Valinor");
            log.atInfo().log("FIRST NESTED BEFORE EACH ==> " + person.toString());
        }

        @Test
        //@DisabledOnOs(MAC)
        @DisplayName("name should be equal")
        void firstNestedEqualTest() {
            assertEquals("Valinor", person.getFirstName());
        }

        @Test
        @DisplayName("name should not be equal")
        void firstNestedNotEqualTest() {
            assertEquals("Valinor", person.getFirstName());
        }

        @Nested
        @TestInstance(PER_CLASS)
        @DisplayName("when instance per class")
        class SecondNested {
            private PersonModel person;

            @BeforeAll
            void arrangeSecondNested() {
                this.person = new PersonModel().toBuilder().build();
                log.atInfo().log("SECOND NESTED BEFORE ALL ==> " + this.person.toString());
            }

            @BeforeEach
            void setupSecondNested() {
                this.person.setFirstName("Sauron");
                log.atInfo().log("SECOND NESTED BEFORE EACH ==> " + this.person.toString());
            }

            @Test
            @DisplayName("name should be equal")
            void secondNestedEqualTest() {
                assertEquals("Sauron", this.person.getFirstName());
            }

            @Test
            @DisplayName("name should not be equal")
            void secondNestedNotEqualTest() {
                assertEquals("Sauron", this.person.getFirstName());
            }
        }
    }
}
