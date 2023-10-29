package edu.hw4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class TwentiethTaskTest {
    private TwentiethTaskTest() {
    }

    private static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of(
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
                }},
                new HashMap<>() {{
                    put("Bird2", "type, age, weight, sex, height");
                    put("Cat2", "height");
                    put("Fish1", "height");
                    put("Spider1", "age, weight");
                }}
            )
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testGetSexOfMostAnimals(Map<String, Set<ValidationError>> input, Map<String, String> expected) {
        var actual = Task20.getNamesAnimalsWithTheirErrorFields(input);
        assertThat(actual).isEqualTo(expected);
    }
}
