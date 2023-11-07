package edu.hw5;

import java.util.stream.Stream;

import edu.hw5.task6.Task6;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class SixthTaskTest {
    private SixthTaskTest() {
    }

    private static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of("achfdbaabgabcaabg", "abc", true),
            Arguments.of("achfdbaabgabcaabg", "abm", false),
            Arguments.of("achfdbaabgabcaabg", "ccc", false),
            Arguments.of("achfdbaabgabcaabg", "aabga", true),
            Arguments.of("achfdbaabgabcaabg", "fbda", false)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testSubstring(String string, String substring, boolean expected) {
        var actual = Task6.isSubsequence(string, substring);
        assertThat(actual).isEqualTo(expected);
    }
}
