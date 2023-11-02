package edu.hw5;

import java.util.regex.Pattern;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class FifthTaskTest {
    private FifthTaskTest() {
    }

    private static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of("А123ВЕ777", true),
            Arguments.of("О777ОО177", true),
            Arguments.of("123АВЕ777", false),
            Arguments.of("А123ВЕ77", false),
            Arguments.of("А123ВЕ7777", false),
            Arguments.of("", false)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testNumber(String number, boolean expected) {
        var actual = Pattern.matches(Task5.PATTERN, number);
        assertThat(actual).isEqualTo(expected);
    }
}
