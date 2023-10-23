package edu.hw3;

import edu.hw3.task5.Task5;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class FifthTaskTest {
    private FifthTaskTest() {
    }

    static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of(
                new String[] {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"},
                "ASC",
                new Object[] {"Thomas Aquinas", "Rene Descartes", "David Hume", "John Locke"}
            ),
            Arguments.of(
                new String[] {"Paul Erdos", "Leonhard Euler", "Carl Gauss"},
                "DESC",
                new Object[] {"Carl Gauss", "Leonhard Euler", "Paul Erdos"}
            ),
            Arguments.of(
                new String[0],
                "DESC",
                new Object[0]
            ),
            Arguments.of(
                null,
                "DESC",
                new Object[0]
            )
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testBracketExpression(String[] contacts, String sortType, Object[] expected) {
        var actual = Task5.parseContacts(contacts, sortType);

        if (expected.equals(new Object[0])) {
            assertThat(contacts).isEqualTo(new Object[0]);
            return;
        }

        assertThat(actual.length).isEqualTo(expected.length);

        for (var i = 0; i < expected.length; i++) {
            assertThat(actual[i]).isEqualTo(expected[i]);
        }
    }
}
