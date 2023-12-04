package edu.hw5;

import java.util.stream.Stream;
import edu.hw5.task4.Task4;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class FourthTaskTest {
    private FourthTaskTest() {
    }

    private static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of("asdsaasdf", false),
            Arguments.of("", false),
            Arguments.of("a|sdsaasdf", true),
            Arguments.of("$~!@#", true),
            Arguments.of("#", true)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testPassword(String password, boolean expected) {
        var actual = Task4.checkPasswordCorrectness(password);
        assertThat(actual).isEqualTo(expected);
    }
}
