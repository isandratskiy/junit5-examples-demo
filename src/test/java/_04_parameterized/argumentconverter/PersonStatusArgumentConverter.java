package _04_parameterized.argumentconverter;

import model.PersonModel;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

public class PersonStatusArgumentConverter implements ArgumentConverter {
    @Override
    public PersonModel convert(Object source, ParameterContext context) throws ArgumentConversionException {
        return null;
    }
}
