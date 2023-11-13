package edu.hw4;

import java.util.List;
import java.util.stream.Stream;

import edu.hw4.task13.Task13;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class ThirteenthTaskTest {
    private ThirteenthTaskTest() {
    }

    private static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of(
                AnimalsList.getSixthList(),
                List.of(
                    new Animal("Cat one one", Animal.Type.CAT, Animal.Sex.M, 10, 400, 600, true),
                    new Animal("Cat two two", Animal.Type.CAT, Animal.Sex.F, 9, 380, 580, true),
                    new Animal("Spider one one", Animal.Type.SPIDER, Animal.Sex.M, 2, 6, 12, true)
                )
            )
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testGetAnimalsWithNamesContainingMoreThanTwoWords(List<Animal> input, List<Animal> expected) {
        var actual = Task13.getAnimalsWithNamesContainingMoreThanTwoWords(input);
        assertThat(actual).isEqualTo(expected);
    }
}
