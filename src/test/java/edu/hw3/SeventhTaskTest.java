package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.assertj.core.api.Assertions.assertThat;

public class SeventhTaskTest {
    private SeventhTaskTest() {
    }
    @Test
    void testNullComparator() {
        TreeMap<String, String> tree = new TreeMap<>(Task7.getNullComparator());
        tree.put(null, "test");

        assertThat(tree.containsKey(null)).isTrue();
    }
}
