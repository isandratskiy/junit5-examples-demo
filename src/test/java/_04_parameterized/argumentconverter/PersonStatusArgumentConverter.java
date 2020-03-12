package _04_parameterized.argumentconverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import model.PersonModel;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

import static java.nio.file.Paths.get;
import static java.util.Arrays.stream;
import static org.junit.jupiter.api.Assertions.*;

public class PersonStatusArgumentConverter implements ArgumentConverter {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @SneakyThrows
    @Override
    public PersonModel convert(Object source, ParameterContext context) throws ArgumentConversionException {
        assertEquals(StatusEnum.class, source.getClass());
        assertTrue(context.getParameter().getType().isAssignableFrom(PersonModel.class));
        return stream(OBJECT_MAPPER.readValue(get(
                "src/test/resources/test-data.json").toFile(), PersonModel[].class))
                .filter(x -> x.getUserStatus().equals(source.toString()))
                .findFirst()
                .orElseThrow(
                        () -> new IllegalArgumentException("Person with user status " + source + " not found")
                );
    }
}
