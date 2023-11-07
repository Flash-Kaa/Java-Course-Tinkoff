package edu.hw4;

import java.util.List;
import java.util.stream.Stream;

import edu.hw4.task17.Task17;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class SeventeenthTaskTest {
    private SeventeenthTaskTest() {
    }

    private static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of(
                AnimalsList.getFourthList(), true
            ),
            Arguments.of(
                AnimalsList.getFirstList(), false
            )
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testGetSexOfMostAnimals(List<Animal> input, Boolean expected) {
        var actual = Task17.doSpidersBiteMoreThanDogs(input);
        assertThat(actual).isEqualTo(expected);
    }
}
