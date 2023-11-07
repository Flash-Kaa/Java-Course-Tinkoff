package edu.hw3;

import edu.hw3.task3.Task3;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class ThirdTaskTest {
    private ThirdTaskTest() {
    }

    static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of(new String[] {"a", "bb", "a", "bb"}, new HashMap<>() {{
                put("bb", 2);
                put("a", 2);
            }}),
            Arguments.of(new String[] {"this", "and", "that", "and"}, new HashMap<>() {{
                put("this", 1);
                put("and", 2);
                put("that", 1);
            }}),
            Arguments.of(new String[] {"код", "код", "код", "bug"}, new HashMap<>() {{
                put("код", 3);
                put("bug", 1);
            }}),
            Arguments.of(new Integer[] {1, 1, 2, 2}, new HashMap<>() {{
                put(1, 2);
                put(2, 2);
            }}),
            Arguments.of(new Object[0], new HashMap<>())
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    <T> void test(T[] expression, Map<T, String> expected) {
        var actual = Task3.freqDict(expression);
        var actualKeys = actual.keySet().stream().toList();
        var expectedKeys = expected.keySet().stream().toList();

        assertThat(actualKeys.size()).isEqualTo(expectedKeys.size());

        for (var i : expectedKeys) {
            assertThat(actual.get(i)).isEqualTo(expected.get(i));
        }
    }
}
