package edu.hw4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class ThirdTaskTest {
    private ThirdTaskTest() {
    }

    private static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of(
                AnimalsList.getFirstList(),
                new HashMap<Animal.Type, Integer>() {{
                    put(Animal.Type.CAT, 2);
                    put(Animal.Type.DOG, 2);
                    put(Animal.Type.BIRD, 2);
                    put(Animal.Type.FISH, 2);
                    put(Animal.Type.SPIDER, 2);
                }}
            ),
            Arguments.of(
                AnimalsList.getThirdList(),
                new HashMap<Animal.Type, Integer>() {{
                    put(Animal.Type.BIRD, 4);
                    put(Animal.Type.FISH, 2);
                    put(Animal.Type.SPIDER, 2);
                }}
            ),
            Arguments.of(
                AnimalsList.getFifthList(),
                new HashMap<Animal.Type, Integer>() {{
                    put(Animal.Type.CAT, 2);
                    put(Animal.Type.DOG, 2);
                    put(Animal.Type.BIRD, 4);
                    put(Animal.Type.FISH, 2);
                    put(Animal.Type.SPIDER, 2);
                }}
            )
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testGetTypesCount(List<Animal> input, Map<Animal.Type, Integer> expected) {
        var actual = Task3.countTypes(input);
        assertThat(actual).isEqualTo(expected);
    }
}
