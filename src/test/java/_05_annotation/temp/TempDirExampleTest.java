package _05_annotation.temp;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static java.nio.file.Files.*;
import static java.util.Arrays.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assumptions.*;

@DisplayName("Temporary directory creation example test")
class TempDirExampleTest {
    @TempDir
    File classFieldTempDir;

    @Test
    @DisplayName("can write into temp file as parameter")
    void canWriteIntoTempFileAsParameter(@TempDir Path tempDir) throws IOException {
        val numbers = tempDir.resolve("numbers.txt");
        val lines = asList("1", "2", "3");
        write(numbers, lines);

        assertAll(
                () -> assertTrue(exists(numbers), "File is not exist"),
                () -> assertLinesMatch(lines, readAllLines(numbers))
        );
    }

    @Test
    @DisplayName("can write into temp file as class field")
    void canWriteIntoTempFileAsClassField() throws IOException {
        assumeTrue(this.classFieldTempDir.isDirectory(), "Should be as directory");

        val letters = new File(this.classFieldTempDir, "letters.txt");
        val lines = asList("x", "y", "z");
        write(letters.toPath(), lines);

        assertAll(
                () -> assertTrue(exists(letters.toPath()), "File is not exist"),
                () -> assertLinesMatch(lines, readAllLines(letters.toPath()))
        );
    }
}
