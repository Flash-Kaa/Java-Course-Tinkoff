package hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Task1Test {
    private Task1 taskClass = new Task1();

    @ParameterizedTest
    @ValueSource(ints = {0, 1000, Integer.MAX_VALUE})
    @DisplayName("")
    void parsingTimeToSeconds(int minutesWithSeconds) {
        var minutes = minutesWithSeconds / 60;
        var seconds = minutesWithSeconds % 60;

        var time = String.format("%d:%d", minutes, seconds);
        var result = taskClass.minutesToSeconds(time);
        assert
    }

}
