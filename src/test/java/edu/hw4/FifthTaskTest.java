package edu.hw4;

import java.util.List;
import java.util.stream.Stream;
import edu.hw4.task5.Task5;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class FifthTaskTest {
    private FifthTaskTest() {
    }

    private static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of(
                AnimalsList.getFourthList(),
                Animal.Sex.M
            )
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testGetSexOfMostAnimals(List<Animal> input, Animal.Sex expected) {
        var actual = Task5.getSexOfMostAnimals(input);
        assertThat(actual).isEqualTo(expected);
    }
}
