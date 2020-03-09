package _04_parameterized.argumentprovider;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.PersonModel;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;

import java.util.stream.Stream;

import static java.nio.file.Paths.get;
import static java.util.Arrays.*;

public class JsonArgumentProvider implements ArgumentsProvider, AnnotationConsumer<JsonSource> {
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	private String resource;

	@Override
	public void accept(JsonSource jsonSource) {
		this.resource = jsonSource.value();
	}

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
		stream(context.getRequiredTestMethod().getParameterTypes())
				.filter(x -> x.isAssignableFrom(PersonModel.class))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Invalid argument type"));
		return readValues(resource).map(Arguments::of);
	}

	private <T> Stream<PersonModel> readValues(String resource) throws java.io.IOException {
		return stream(OBJECT_MAPPER.readValue(get(resource).toFile(), PersonModel[].class));
	}
}
