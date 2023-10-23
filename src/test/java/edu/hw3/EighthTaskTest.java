package edu.hw3;

import edu.hw3.task8.BackwardIterator;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class EighthTaskTest {
    private EighthTaskTest() {
    }

    @Test
    void testBackwardIterator() {
        List<Integer> expected = List.of(3, 2, 1);
        List<Integer> actual = new ArrayList<>();

        var backwardIterator = new BackwardIterator<>(List.of(1,2,3));

        while (backwardIterator.hasNext()) {
            actual.add((Integer) backwardIterator.next());
        }

        assertThatThrownBy(() -> backwardIterator.next())
            .isExactlyInstanceOf(IndexOutOfBoundsException.class);
        assertThat(actual.size()).isEqualTo(expected.size());

        for(var i = 0; i < actual.size(); i++) {
            assertThat(actual.get(i)).isEqualTo(expected.get(i));
        }
    }
}
