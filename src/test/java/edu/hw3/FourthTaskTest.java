package edu.hw3;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class FourthTaskTest {
    private FourthTaskTest() {
    }

    static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of(1, "I"),
            Arguments.of(2, "II"),
            Arguments.of(9, "IX"),
            Arguments.of(12, "XII"),
            Arguments.of(16, "XVI"),
            Arguments.of(40, "XL"),
            Arguments.of(50, "L"),
            Arguments.of(49, "XLIX"),
            Arguments.of(71, "LXXI"),
            Arguments.of(93, "XCIII"),
            Arguments.of(500, "D"),
            Arguments.of(519, "DXIX"),
            Arguments.of(3999, "MMMCMXCIX")
        );
    }

    static Stream<Arguments> argumentProviderForTestExceptions() {
        return Stream.of(
            Arguments.of(0),
            Arguments.of(4000),
            Arguments.of(Integer.MIN_VALUE),
            Arguments.of(Integer.MAX_VALUE)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testBracketExpression(int number, String expected) {
        var actual = Task4.convertToRoman(number);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("argumentProviderForTestExceptions")
    void testBracketExpressionWithException(int number) {
        assertThatThrownBy(() -> Task4.convertToRoman(number))
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
