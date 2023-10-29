package edu.hw4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class FirstTaskTest {
    private FirstTaskTest() {
    }

    private static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of(
                AnimalsList.getFirstList(),
                Arrays.asList(
                    new Animal("Spider1", Animal.Type.SPIDER, Animal.Sex.M, 1, 1, 2, false),
                    new Animal("Spider2", Animal.Type.SPIDER, Animal.Sex.F, 1, 1, 1, false),
                    new Animal("Fish1", Animal.Type.FISH, Animal.Sex.M, 1, 2, 3, false),
                    new Animal("Fish2", Animal.Type.FISH, Animal.Sex.F, 1, 2, 1, false),
                    new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.M, 2, 5, 1, false),
                    new Animal("Bird2", Animal.Type.BIRD, Animal.Sex.F, 3, 6, 2, false),
                    new Animal("Cat2", Animal.Type.CAT, Animal.Sex.F, 4, 11, 18, false),
                    new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 3, 12, 15, true),
                    new Animal("Dog2", Animal.Type.DOG, Animal.Sex.F, 4, 18, 22, true),
                    new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 5, 20, 25, true)
                )
            ),
            Arguments.of(
                AnimalsList.getSecondList(),
                Arrays.asList(
                    new Animal("Spider1", Animal.Type.SPIDER, Animal.Sex.M, 1, 1, 3, false),
                    new Animal("Fish1", Animal.Type.FISH, Animal.Sex.M, 1, 2, 4, false),
                    new Animal("Fish2", Animal.Type.FISH, Animal.Sex.F, 1, 2, 1, false),
                    new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.M, 2, 5, 1, false),
                    new Animal("Bird2", Animal.Type.BIRD, Animal.Sex.F, 3, 6, 2, false),
                    new Animal("Cat2", Animal.Type.CAT, Animal.Sex.F, 4, 11, 18, false),
                    new Animal("Spider2", Animal.Type.SPIDER, Animal.Sex.F, 4, 11, 31, false),
                    new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 3, 12, 15, true),
                    new Animal("Dog2", Animal.Type.DOG, Animal.Sex.F, 4, 18, 22, true),
                    new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 5, 20, 25, true)
                )
            )
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testSortByHeight(List<Animal> input, List<Animal> expected) {
        var actual = Task1.sortByHeight(input);
        assertThat(actual).isEqualTo(expected);
    }
}
