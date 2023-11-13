package edu.hw4;

import java.util.List;
import java.util.stream.Stream;

import edu.hw4.task7.Task7;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class SeventhTaskTest {
    private SeventhTaskTest() {
    }

    private static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of(
                AnimalsList.getFirstList(),
                new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 5, 20, 25, true)
            )
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testGetSexOfMostAnimals(List<Animal> input, Animal expected) {
        var actual = Task7.getOldest(input);
        assertThat(actual).isEqualTo(expected);
    }
}
