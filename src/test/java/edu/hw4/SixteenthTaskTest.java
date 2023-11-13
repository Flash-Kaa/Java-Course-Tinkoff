package edu.hw4;

import java.util.List;
import java.util.stream.Stream;

import edu.hw4.task16.Task16;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class SixteenthTaskTest {
    private SixteenthTaskTest() {
    }

    private static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of(
                AnimalsList.getFirstList(),
                List.of(
                    new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 3, 12, 15, true),
                    new Animal("Cat2", Animal.Type.CAT, Animal.Sex.F, 4, 11, 18, false),
                    new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 5, 20, 25, true),
                    new Animal("Dog2", Animal.Type.DOG, Animal.Sex.F, 4, 18, 22, true),
                    new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.M, 2, 5, 1, false),
                    new Animal("Bird2", Animal.Type.BIRD, Animal.Sex.F, 3, 6, 2, false),
                    new Animal("Fish1", Animal.Type.FISH, Animal.Sex.M, 1, 2, 3, false),
                    new Animal("Fish2", Animal.Type.FISH, Animal.Sex.F, 1, 2, 1, false),
                    new Animal("Spider1", Animal.Type.SPIDER, Animal.Sex.M, 1, 1, 2, false),
                    new Animal("Spider2", Animal.Type.SPIDER, Animal.Sex.F, 1, 1, 1, false)
                )
            ),
            Arguments.of(
                AnimalsList.getFifthList(),
                List.of(
                    new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 10, 400, 600, true),
                    new Animal("Cat2", Animal.Type.CAT, Animal.Sex.F, 9, 380, 580, true),
                    new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 6, 12, 12, true),
                    new Animal("Dog2", Animal.Type.DOG, Animal.Sex.F, 7, 14, 8, true),
                    new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.M, 4, 4, 2, true),
                    new Animal("Bird3", Animal.Type.BIRD, Animal.Sex.M, 3, 5, 3, false),
                    new Animal("Bird2", Animal.Type.BIRD, Animal.Sex.F, 3, 38, 9, true),
                    new Animal("Bird4", Animal.Type.BIRD, Animal.Sex.F, 2, 4, 25, false),
                    new Animal("Fish1", Animal.Type.FISH, Animal.Sex.M, 2, 1, 2, false),
                    new Animal("Fish2", Animal.Type.FISH, Animal.Sex.F, 2, 11, 22, false),
                    new Animal("Spider1", Animal.Type.SPIDER, Animal.Sex.M, 2, 6, 12, true),
                    new Animal("Spider2", Animal.Type.SPIDER, Animal.Sex.F, 2, 65, 13, true)
                )
            )
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testSortAnimalsBySpeciesGenderName(List<Animal> input, List<Animal> expected) {
        var actual = Task16.sortAnimalsBySpeciesGenderName(input);
        assertThat(actual).isEqualTo(expected);
    }
}
