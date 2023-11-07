package edu.hw3;

import java.util.stream.Stream;
import edu.hw3.task1.Task1;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class FirstTaskTest {
    private FirstTaskTest() {
    }

    static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of("Hello world!", "Svool dliow!"),
            Arguments.of(
                "Any fool can write code that a computer can understand. " +
                    "Good programmers write code that humans can understand. ― Martin Fowler",
                "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. " +
                    "Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi"
            ),
            Arguments.of("", ""),
            Arguments.of("!!!!!!", "!!!!!!"),
            Arguments.of("!!!abc!!!", "!!!zyx!!!"),
            Arguments.of("!!!ABC!!!", "!!!ZYX!!!"),
            Arguments.of("111", "111"),
            Arguments.of("AAAaaaAAAaaa", "ZZZzzzZZZzzz")
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testAtbashEncryption(String input, String expected) {
        var actual = Task1.atbash(input);
        assertThat(actual).isEqualTo(expected);
    }
}
