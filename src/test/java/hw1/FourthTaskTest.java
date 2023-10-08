package hw1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class FourthTaskTest {
    private FourthTaskTest() {
    }

    static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of("123456", "214365"),
            Arguments.of("hTsii  s aimex dpus rtni.g", "This is a mixed up string."),
            Arguments.of("badce", "abcde"),
            Arguments.of("aaaa", "aaaa"),
            Arguments.of("12345", "21435"),
            Arguments.of("a", "a"),
            Arguments.of("", "")
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testFixingString(String input, String expected) {
        var result = Task4.fixString(input);

        assertThat(result).isEqualTo(expected);
    }
}
