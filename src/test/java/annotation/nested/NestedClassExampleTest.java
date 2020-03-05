package annotation.nested;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Nested tests example")
class NestedClassExampleTest {

    @BeforeEach
    void arrange() {

    }

    @Nested
    class FirstNested {
        @Test
        void firstNestedEqualTest() {

        }

        @Test
        void firstNestedNotEqualTest() {

        }
    }

    @Nested
    class SecondNested {
        @Test
        void secondNestedEqualTest() {

        }

        @Test
        void secondNestedNotEqualTest() {

        }
    }
}
