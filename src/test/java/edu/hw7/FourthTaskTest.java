package edu.hw7;

import edu.hw7.task4.Task4;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class FourthTaskTest {
    private FourthTaskTest() {
    }

    static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of(
                100, 1, Math.PI, 1
            ),
            Arguments.of(
                1000, 5, Math.PI, 0.5
            ),
            Arguments.of(
                10000, 10, Math.PI, 0.4
            ),
            Arguments.of(
                100000, 20, Math.PI, 0.2
            ),
            Arguments.of(
                1000000, 50, Math.PI, 0.1
            ),
            Arguments.of(
                10000000, 100, Math.PI, 0.05
            )
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void test(int n, int threadsCount, double expected, double inaccuracy) {
        var actual = Task4.calculatePiMultiThread(n, threadsCount);

        assertThat(actual)
            .isBetween(expected - inaccuracy, expected + inaccuracy);
    }
}
