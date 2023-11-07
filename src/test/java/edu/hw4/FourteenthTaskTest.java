package edu.hw4;

import java.util.List;
import java.util.stream.Stream;

import edu.hw4.task14.Task14;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class FourteenthTaskTest {
    private FourteenthTaskTest() {
    }

    private static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of(
                AnimalsList.getFirstList(), 40, false
            ),
            Arguments.of(
                AnimalsList.getSecondList(), 10, true
            ),
            Arguments.of(
                AnimalsList.getThirdList(), 13, false
            ),
            Arguments.of(
                AnimalsList.getFourthList(), 0, false
            ),
            Arguments.of(
                AnimalsList.getFifthList(), 13, true
            )
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testGetSexOfMostAnimals(List<Animal> input, int k, Boolean expected) {
        var actual = Task14.haveDogWithHeightMoreK(input, k);
        assertThat(actual).isEqualTo(expected);
    }
}
