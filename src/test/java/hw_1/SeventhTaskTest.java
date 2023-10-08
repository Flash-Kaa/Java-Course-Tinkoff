package hw_1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class SeventhTaskTest {
    private SeventhTaskTest() {
    }

    static Stream<Arguments> argumentProviderForRight() {
        return Stream.of(
            Arguments.of(8, 1, 4),
            Arguments.of(16, 1, 8),
            Arguments.of(17, 1, 24),
            Arguments.of(17, 2, 12),
            Arguments.of(8, 0, 8),
            Arguments.of(8, 8, 8),
            Arguments.of(8, 16, 8),
            Arguments.of(8, 111120, 8),
            Arguments.of(17, 18, 6),
            Arguments.of(1, 1, 1),
            Arguments.of(16, -1, 1),
            Arguments.of(17, -2, 6)
        );
    }

    static Stream<Arguments> argumentProviderForLeft() {
        return Stream.of(
            Arguments.of(16, 1, 1),
            Arguments.of(17, 2, 6),
            Arguments.of(17, 17, 6),
            Arguments.of(17, 0, 17),
            Arguments.of(17, 20, 17),
            Arguments.of(17, 55, 17),
            Arguments.of(17, 11115, 17),
            Arguments.of(1, 1, 1),
            Arguments.of(8, -1, 4),
            Arguments.of(17, -2, 12),
            Arguments.of(17, -1, 24)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProviderForRight")
    void testRightShift(int number, int shift, int expected) {
        var result = Task7.rotateRight(number, shift);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("argumentProviderForLeft")
    void testLeftShift(int number, int shift, int expected) {
        var result = Task7.rotateLeft(number, shift);

        assertThat(result).isEqualTo(expected);
    }
}
