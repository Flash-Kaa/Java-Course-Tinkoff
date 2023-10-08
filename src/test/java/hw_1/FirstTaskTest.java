package hw_1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.Random;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FirstTaskTest {
    private FirstTaskTest() {
    }

    @ParameterizedTest()
    @ValueSource(ints = {0, 1000, Integer.MAX_VALUE})
    @DisplayName("Fixed numbers")
    void testWithFixedSeconds(int seconds) {
        var time = parsingSecondsToStringTime(seconds);
        var result = Task1.minutesToSeconds(time);

        assertThat(result).isEqualTo(seconds);
    }

    @ParameterizedTest()
    @ValueSource(ints = {100000})
    @DisplayName("Random numbers")
    void testWithRandomSeconds(int testCount) {
        final var rand = new Random();
        final var minSeconds = 0;
        final var maxSeconds = Integer.MAX_VALUE;

        for (var i = 0; i < testCount; i++) {
            var timeInSeconds = rand.nextInt(minSeconds, maxSeconds);

            var time = parsingSecondsToStringTime(timeInSeconds);
            var result = Task1.minutesToSeconds(time);

            assertThat(result).isEqualTo(timeInSeconds);
        }
    }

    private static String parsingSecondsToStringTime(int timeInSeconds) {
        var minutes = timeInSeconds / 60;
        var seconds = timeInSeconds % 60;

        return String.format("%d:%d", minutes, seconds);
    }
}
