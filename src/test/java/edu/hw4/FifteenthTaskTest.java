package edu.hw4;

import java.util.List;
import java.util.stream.Stream;

import edu.hw4.task15.Task15;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class FifteenthTaskTest {
    private FifteenthTaskTest() {
    }

    private static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of(
                AnimalsList.getFirstList(), 2, 3, 18
            ),
            Arguments.of(
                AnimalsList.getThirdList(), 1, 4, 63
            )
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testGetTotalWeightBySpeciesInAgeRange(List<Animal> input, int k, int l, Integer expected) {
        var actual = Task15.getTotalWeightBySpeciesInAgeRange(input, k, l);
        assertThat(actual).isEqualTo(expected);
    }
}
