package edu.hw5;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class SecondTaskTest {
    private SecondTaskTest() {
    }

    private static Stream<Arguments> argumentProviderForAllFridays() {
        return Stream.of(
            Arguments.of(
                1925,
                List.of(
                    LocalDate.of(1925, 2, 13),
                    LocalDate.of(1925, 3, 13),
                    LocalDate.of(1925, 11, 13)
                )
            ),
            Arguments.of(
                2024,
                List.of(
                    LocalDate.of(2024, 9, 13),
                    LocalDate.of(2024, 12, 13)
                )
            )
        );
    }

    private static Stream<Arguments> argumentProviderForNextFriday() {
        return Stream.of(
            Arguments.of(
                LocalDate.of(2024, 9, 13),
                LocalDate.of(2024, 12, 13)
            ),
            Arguments.of(
                LocalDate.of(1925, 2, 13),
                LocalDate.of(1925, 3, 13)
            ),
            Arguments.of(
                LocalDate.of(1925, 3, 13),
                LocalDate.of(1925, 11, 13)
            ),
            Arguments.of(
                LocalDate.of(2024, 12, 13),
                LocalDate.of(2025, 6, 13)
            )
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProviderForAllFridays")
    void testFindAllFridays(int input, List<LocalDate> expected) {
        var actual = Task2.findFridaysOn13ths(input);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("argumentProviderForNextFriday")
    void testFindNextFriday(LocalDate input, LocalDate expected) {
        var actual = Task2.findNextFriday13th(input);
        assertThat(actual).isEqualTo(expected);
    }
}
