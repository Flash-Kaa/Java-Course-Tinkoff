package edu.hw3;

import edu.hw3.task2.Task2;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class SecondTaskTest {
    private SecondTaskTest() {
    }

    static Stream<Arguments> argumentProviderForTestExceptions() {
        return Stream.of(
            Arguments.of("(()()())("),
            Arguments.of(")(()()())"),
            Arguments.of(")(()()())("),
            Arguments.of(")(()()())("),
            Arguments.of("(a)"),
            Arguments.of("a")
        );
    }

    static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of("()()()", List.of("()", "()", "()")),
            Arguments.of("((()))", List.of("((()))")),
            Arguments.of("((()))(())()()(()())", List.of("((()))", "(())", "()", "()", "(()())")),
            Arguments.of("((())())(()(()()))", List.of("((())())", "(()(()()))"))
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testBracketExpression(String expression, List<String> expected) {
        var actual = Task2.clusterize(expression);

        assertThat(actual.size()).isEqualTo(expected.size());

        for(var i = 0; i < actual.size(); i++) {
            assertThat(actual.get(i)).isEqualTo(expected.get(i));
        }
    }

    @ParameterizedTest
    @MethodSource("argumentProviderForTestExceptions")
    void testBracketExpressionWithException(String expression) {
        assertThatThrownBy(() -> Task2.clusterize(expression))
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
