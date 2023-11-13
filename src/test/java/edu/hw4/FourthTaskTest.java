package edu.hw4;

import java.util.List;
import java.util.stream.Stream;

import edu.hw4.task4.Task4;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class FourthTaskTest {
    private FourthTaskTest() {
    }

    private static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of(
                AnimalsList.getFirstList(),
                new Animal("Spider2", Animal.Type.SPIDER, Animal.Sex.F, 1, 1, 1, false)
            ),
            Arguments.of(
                AnimalsList.getSecondList(),
                new Animal("Spider2", Animal.Type.SPIDER, Animal.Sex.F, 4, 11, 31, false)
            )
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testGetAnimalWithLongestName(List<Animal> input, Animal expected) {
        var actual = Task4.getAnimalWithLongestName(input);
        assertThat(actual).isEqualTo(expected);
    }
}
