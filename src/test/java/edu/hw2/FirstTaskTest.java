package edu.hw2;

import edu.hw2.expressions.Addition;
import edu.hw2.expressions.Constant;
import edu.hw2.expressions.Exponent;
import edu.hw2.expressions.Expr;
import edu.hw2.expressions.Multiplication;
import edu.hw2.expressions.Negate;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class FirstTaskTest {
    private FirstTaskTest() {
    }

    static Stream<Arguments> argumentProvider() {
        var constant = new Constant(1);

        return Stream.of(
            Arguments.of(new Addition(null, constant)),
            Arguments.of(new Addition(constant, null)),
            Arguments.of(new Multiplication(constant, null)),
            Arguments.of(new Multiplication(null, constant)),
            Arguments.of(new Exponent(null, 1)),
            Arguments.of(new Negate(null))
        );
    }

    @Test
    void testFromTask() {
        var two = new Constant(2); // 2
        var four = new Constant(4); // 4
        var negOne = new Negate(new Constant(1)); // -1
        var sumTwoFour = new Addition(two, four); // 2 + 4 = 6
        var mult = new Multiplication(sumTwoFour, negOne); // 6 * (-1) = -6
        var exp = new Exponent(mult, 2); // -6 ^ 2 = 36
        var res = new Addition(exp, new Constant(1)); // 36 + 1 = 37

        assertThat(res.evaluate()).isEqualTo(37);
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testCallingWithNullArgument(Expr expression) {
        assertThatThrownBy(() -> expression.evaluate())
            .isExactlyInstanceOf(NullPointerException.class);
    }
}
