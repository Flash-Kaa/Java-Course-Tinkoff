package hw_1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class FifthTaskTest {
    private FifthTaskTest() {
    }

    static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of(11211230, true),
            Arguments.of(13001120, true),
            Arguments.of(23336014, true),
            Arguments.of(11, true),
            Arguments.of(123312, true),
            Arguments.of(363, true),
            Arguments.of(9, false),
            Arguments.of(999, true),
            Arguments.of(991, true),
            Arguments.of(992, true),
            Arguments.of(993, false)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testCanFindPalindrome(int input, boolean expected) {
        var result = Task5.isPalindromeDescendant(input);

        assertThat(result).isEqualTo(expected);
    }
}
