package edu.hw4;

import java.util.List;
import java.util.stream.Stream;

import edu.hw4.task9.Task9;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class NinthTaskTest {
    private NinthTaskTest() {
    }

    private static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of(
                AnimalsList.getFirstList(), 36
            ),
            Arguments.of(
                AnimalsList.getThirdList(), 24
            )
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testGetSumPaws(List<Animal> input, Integer expected) {
        var actual = Task9.getSumPaws(input);
        assertThat(actual).isEqualTo(expected);
    }
}
