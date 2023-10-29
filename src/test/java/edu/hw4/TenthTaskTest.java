package edu.hw4;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class TenthTaskTest {
    private TenthTaskTest() {
    }

    private static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of(
                AnimalsList.getFirstList(),
                List.of(
                    new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 3, 12, 15, true),
                    new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 5, 20, 25, true),
                    new Animal("Bird2", Animal.Type.BIRD, Animal.Sex.F, 3, 6, 2, false),
                    new Animal("Fish1", Animal.Type.FISH, Animal.Sex.M, 1, 2, 3, false),
                    new Animal("Fish2", Animal.Type.FISH, Animal.Sex.F, 1, 2, 1, false),
                    new Animal("Spider1", Animal.Type.SPIDER, Animal.Sex.M, 1, 1, 2, false),
                    new Animal("Spider2", Animal.Type.SPIDER, Animal.Sex.F, 1, 1, 1, false)
                )
            )
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testGetAnimalsWithMismatchedAgeAndPaws(List<Animal> input, List<Animal> expected) {
        var actual = Task10.getAnimalsWithMismatchedAgeAndPaws(input);
        assertThat(actual).isEqualTo(expected);
    }
}
