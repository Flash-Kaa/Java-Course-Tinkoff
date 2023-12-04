package edu.hw5;

import java.time.LocalDate;
import java.util.stream.Stream;

import edu.hw5.task3.Task3;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class ThirdTaskTest {
    private ThirdTaskTest() {
    }

    private static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of(
                "2020-10-10",
                LocalDate.of(2020, 10, 10)
            ),
            Arguments.of(
                "2020-12-2",
                LocalDate.of(2020, 12, 2)
            ),
            Arguments.of(
                "1/3/1976",
                LocalDate.of(1976, 3, 1)
            ),
            Arguments.of(
                "1/3/20",
                LocalDate.of(2020, 3, 1)
            ),
            Arguments.of(
                "tomorrow",
                LocalDate.now().plusDays(1)
            ),
            Arguments.of(
                "today",
                LocalDate.now()
            ),
            Arguments.of(
                "yesterday",
                LocalDate.now().minusDays(1)
            ),
            Arguments.of(
                "1 day ago",
                LocalDate.now().minusDays(1)
            ),
            Arguments.of(
                "2234 day ago",
                LocalDate.now().minusDays(2234)
            ),
            Arguments.of(
                "error",
                null
            )
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testDateFormats(String input, LocalDate expected) {
        var actual = Task3.parseDate(input);
        if (actual.isEmpty()) {
            assertThat(expected == null).isTrue();
            return;
        }
        assertThat(actual.get()).isEqualTo(expected);
    }
}
