package edu.hw4;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class TwelfthTaskTest {
    private TwelfthTaskTest() {
    }

    private static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of(
                AnimalsList.getFirstList(), 6
            ),
            Arguments.of(
                AnimalsList.getSecondList(), 7
            ),
            Arguments.of(
                AnimalsList.getThirdList(), 3
            ),
            Arguments.of(
                AnimalsList.getFourthList(), 7
            ),
            Arguments.of(
                AnimalsList.getFifthList(), 6
            )
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testGetCountAnimalsWithWeightExceedingHeight(List<Animal> input, Integer expected) {
        var actual = Task12.getCountAnimalsWithWeightExceedingHeight(input);
        assertThat(actual).isEqualTo(expected);
    }
}
