package edu.hw4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import edu.hw4.task2.Task2;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class SecondTaskTest {
    private SecondTaskTest() {
    }

    private static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of(
                AnimalsList.getFirstList(), 6,
                Arrays.asList(
                    new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 5, 20, 25, true),
                    new Animal("Dog2", Animal.Type.DOG, Animal.Sex.F, 4, 18, 22, true),
                    new Animal("Cat2", Animal.Type.CAT, Animal.Sex.F, 4, 11, 18, false),
                    new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 3, 12, 15, true),
                    new Animal("Fish1", Animal.Type.FISH, Animal.Sex.M, 1, 2, 3, false),
                    new Animal("Bird2", Animal.Type.BIRD, Animal.Sex.F, 3, 6, 2, false)
                )
            ),
            Arguments.of(
                AnimalsList.getSecondList(), 8,
                Arrays.asList(
                    new Animal("Spider2", Animal.Type.SPIDER, Animal.Sex.F, 4, 11, 31, false),
                    new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 5, 20, 25, true),
                    new Animal("Dog2", Animal.Type.DOG, Animal.Sex.F, 4, 18, 22, true),
                    new Animal("Cat2", Animal.Type.CAT, Animal.Sex.F, 4, 11, 18, false),
                    new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 3, 12, 15, true),
                    new Animal("Fish1", Animal.Type.FISH, Animal.Sex.M, 1, 2, 4, false),
                    new Animal("Spider1", Animal.Type.SPIDER, Animal.Sex.M, 1, 1, 3, false),
                    new Animal("Bird2", Animal.Type.BIRD, Animal.Sex.F, 3, 6, 2, false)
                )
            ),
            Arguments.of(
                AnimalsList.getThirdList(), 0, List.of()
            )
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testSortByWeightAndTakeKFirst(List<Animal> input, int k, List<Animal> expected) {
        var actual = Task2.sortByWeightAndTakeKFirst(input, k);
        assertThat(actual).isEqualTo(expected);
    }
}
