package hw1;

import org.intellij.lang.annotations.MagicConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.Random;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class SixthTaskTest {
    private SixthTaskTest() {
    }

    static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of(6621, 5),
            Arguments.of(6554, 4),
            Arguments.of(1234, 3),
            Arguments.of(1000, 5),
            Arguments.of(6174, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    @DisplayName("Testing with fixed numbers")
    void testFindKOperations(int number, int expected) {
        var result = Task6.countK(number);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {10000})
    @DisplayName("Testing with random numbers")
    @MagicConstant
    void testFindKOperationsWithRandomNumbers(int testCount) {
        var rand = new Random();
        var minValue = 1000;
        var maxValue = 9999;

        for (var i = 0; i < testCount; i++) {
            var number = rand.nextInt(minValue, maxValue);

            if (number % 1111 == 0) {
                continue;
            }

            var operationsCount = Task6.countK(number);
            assertThat(operationsCount).isLessThanOrEqualTo(7);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {999, 10000, 5555})
    @DisplayName("Testing calling exceptions with fixed numbers")
    void testThrowException(int number) {
        assertThatThrownBy(() -> Task6.countK(number))
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {10000})
    @DisplayName("Testing calling exceptions with random numbers not in range")
    @MagicConstant
    void testThrowExceptionWithRandomNumbersNotInRange(int testCount) {
        var rand = new Random();
        var minValueInRange = 1000;
        var maxValueInRange = 9999;

        for (var i = 0; i < testCount / 2; i++) {
            var number = rand.nextInt(minValueInRange);
            testThrowException(number);
        }

        for (var i = 0; i < testCount / 2; i++) {
            var number = rand.nextInt(maxValueInRange, Integer.MAX_VALUE);
            testThrowException(number);
        }
    }

    @Test
    @DisplayName("Testing calling exceptions with random numbers with repeated digit")
    @MagicConstant
    void testThrowExceptionWithRandomNumbersWithRepeatedDigit() {
        var value = 1111;
        for (var i = 1; i < 10; i++) {
            testThrowException(value * i);
        }
    }
}
