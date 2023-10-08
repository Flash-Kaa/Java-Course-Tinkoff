package hw1;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ThirdTaskTest {
    private ThirdTaskTest() {
    }

    static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of(new int[] {1, 2, 3, 4}, new int[] {0, 6}, true),
            Arguments.of(new int[] {3, 1}, new int[] {4, 0}, true),
            Arguments.of(new int[] {9, 9, 8}, new int[] {8, 9}, false),
            Arguments.of(new int[] {1, 2, 3, 4}, new int[] {2, 3}, false),
            Arguments.of(new int[] {1}, new int[] {1}, false),
            Arguments.of(new int[] {}, new int[] {2, 3}, false),
            Arguments.of(new int[] {2, 3}, new int[] {}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testIncludedInArray(int[] firstArr, int[] secondArr, boolean expected) {
        var result = Task3.isNestable(firstArr, secondArr);

        assertThat(result).isEqualTo(expected);
    }
}
