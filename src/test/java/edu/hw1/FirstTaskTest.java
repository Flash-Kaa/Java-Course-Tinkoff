package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.Random;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FirstTaskTest {
    private FirstTaskTest() {
    }

    static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of("00:1", 1),
            Arguments.of("1:1", 61),
            Arguments.of("1:13", 73),
            Arguments.of("1000:13", 60013),
            Arguments.of("10:60", -1),
            Arguments.of("10:100", -1),
            Arguments.of("-1:10", -1),
            Arguments.of("ups:ups", -1),
            Arguments.of("ups:ups:doubleUps", -1)
        );
    }

    @ParameterizedTest()
    @MethodSource("argumentProvider")
    @DisplayName("Fixed numbers")
    void testFixedInputs(String inputTime, int expectedResult) {
        var result = Task1.minutesToSeconds(inputTime);

        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest()
    @ValueSource(ints = {0, 1000, Integer.MAX_VALUE})
    @DisplayName("Fixed numbers")
    void testWithFixedSeconds(int seconds) {
        var time = parsingSecondsToStringTime(seconds);
        var result = Task1.minutesToSeconds(time);

        assertThat(result).isEqualTo(seconds);
    }

    @ParameterizedTest()
    @ValueSource(ints = {100000})
    @DisplayName("Random numbers")
    void testWithRandomSeconds(int testCount) {
        final var rand = new Random();
        final var minSeconds = 0;
        final var maxSeconds = Integer.MAX_VALUE;

        for (var i = 0; i < testCount; i++) {
            var timeInSeconds = rand.nextInt(minSeconds, maxSeconds);

            var time = parsingSecondsToStringTime(timeInSeconds);
            var result = Task1.minutesToSeconds(time);

            assertThat(result).isEqualTo(timeInSeconds);
        }
    }

    private static String parsingSecondsToStringTime(int timeInSeconds) {
        var minutes = timeInSeconds / 60;
        var seconds = timeInSeconds % 60;

        return String.format("%d:%d", minutes, seconds);
    }
}
