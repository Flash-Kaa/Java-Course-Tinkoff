package hw_1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.Random;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SecondTaskTest {
    private SecondTaskTest() {
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 10, 9999, 111111, Integer.MAX_VALUE})
    @DisplayName("Positive numbers")
    void testWithPositiveNumbers(int number) {
        var expected = findLengthNumber(number);
        var result = Task2.countDigits(number);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -11, -100, -999999, Integer.MIN_VALUE})
    @DisplayName("Negative numbers")
    void testWithNegativeNumbers(int number) {
        var expected = findLengthNumber(number);
        var result = Task2.countDigits(number);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {100000})
    @DisplayName("Random numbers")
    void testWithRandomNumbers(int testCount) {
        final var rand = new Random();
        final var minNumber = Integer.MIN_VALUE;
        final var maxNumber = Integer.MAX_VALUE;

        for (var i = 0; i < testCount; i++) {
            var number = rand.nextInt(minNumber, maxNumber);

            var expected = findLengthNumber(number);
            var result = Task2.countDigits(number);

            assertThat(result).isEqualTo(expected);
        }
    }

    private static int findLengthNumber(int number) {
        // abs(int min value) == 1 + abs(int max value)
        // => the minimum integer when converted to positive goes beyond integers
        // => abs(int min value + 1) == abs(int max value) => that is all right
        if (number == Integer.MIN_VALUE) {
            number++;
        }

        return Integer.toString(Math.abs(number)).length();
    }
}
