package edu.hw5;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class FirstTaskTest {
    private FirstTaskTest() {
    }

    private static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of(
                List.of(
                    "2022-03-12, 20:20 - 2022-03-12, 23:50",
                    "2022-04-01, 21:30 - 2022-04-02, 01:20"
                ),
                LocalTime.of(3, 40)
            ),
            Arguments.of(
                List.of(
                    "2022-03-12, 23:20 - 2022-03-12, 23:50"
                ),
                LocalTime.of(0, 30)
            ),
            Arguments.of(
                List.of(
                    "2022-03-12, 23:50 - 2022-03-12, 23:50",
                    "2022-03-15, 20:00 - 2022-03-15, 20:00",
                    "2022-05-06, 13:41 - 2022-05-06, 13:41"
                ),
                LocalTime.of(0, 0)
            ),
            Arguments.of(
                List.of(
                    "2022-03-12, 23:50 - 2022-03-13, 00:50"
                ),
                LocalTime.of(1, 0)
            ),
            Arguments.of(
                List.of(
                    "2022-03-12, 23:50 - 2022-03-13, 00:50",
                    "2022-03-12, 20:30 - 2022-03-12, 23:50",
                    "2022-03-12, 11:50 - 2022-03-12, 11:56",
                    "2022-03-12, 01:01 - 2022-03-12, 11:00"
                ),
                LocalTime.of(3, 36)
            )
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testGetSessionTime(List<String> input, LocalTime expected) {
        var actual = Task1.calculateAverageSessionDurationInMinutes(input);
        assertThat(actual).isEqualTo(expected);
    }
}
