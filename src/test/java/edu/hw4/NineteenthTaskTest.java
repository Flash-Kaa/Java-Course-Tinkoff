package edu.hw4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import edu.hw4.task19.Task19;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class NineteenthTaskTest {
    private NineteenthTaskTest() {
    }

    private static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of(
                AnimalsList.getFirstList(),
                new HashMap<String, Set<ValidationError>>()
            ),
            Arguments.of(
                AnimalsList.getListWithErrors(),
                new HashMap<String, Set<ValidationError>>() {{
                    put(
                        "Cat2",
                        new HashSet<>() {{
                            add(new ValidationError("height can't be less or equal zero"));
                        }}
                    );
                    put(
                        "Fish1",
                        new HashSet<>() {{
                            add(new ValidationError("height can't be less or equal zero"));
                        }}
                    );
                    put(
                        "Spider1",
                        new HashSet<>() {{
                            add(new ValidationError("age can't be less then zero"));
                            add(new ValidationError("weight can't be less or equal zero"));
                        }}
                    );
                    put(
                        "Bird2",
                        new HashSet<>() {{
                            add(new ValidationError("type can't be null"));
                            add(new ValidationError("sex can't be null"));
                            add(new ValidationError("age can't be less then zero"));
                            add(new ValidationError("height can't be less or equal zero"));
                            add(new ValidationError("weight can't be less or equal zero"));
                        }}
                    );
                }}
            )
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testGetNamesAnimalsWithExceptions(List<Animal> input, Map<String, Set<ValidationError>> expected) {
        var actual = Task19.getNamesAnimalsWithExceptions(input);
        assertThat(actual).isEqualTo(expected);
    }
}
