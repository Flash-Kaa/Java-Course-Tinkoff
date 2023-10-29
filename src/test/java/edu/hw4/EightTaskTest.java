package edu.hw4;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class EightTaskTest {
    private EightTaskTest() {
    }

    private static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of(
                AnimalsList.getFirstList(), 8,
                new Animal("Fish1", Animal.Type.FISH, Animal.Sex.M, 1, 2, 3, false)
            ),
            Arguments.of(
                AnimalsList.getSecondList(), 11,
                new Animal("Fish1", Animal.Type.FISH, Animal.Sex.M, 1, 2, 4, false)
            )
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testGetHeaviestAnimalAmongAnimalsBelowK(List<Animal> input, int k, Animal expected) {
        var actual = Task8.getHeaviestAnimalAmongAnimalsBelowK(input, k);
        assertThat(actual).isEqualTo(expected);
    }
}
