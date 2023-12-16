package edu.hw11;

import edu.hw11.task1.Task1;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FirstTaskTest {
    private FirstTaskTest() {
    }

    @Test
    void test() {
        Object result = Task1.getObjectWithStaticToString();
        assertThat(result.toString()).isEqualTo("Hello, ByteBuddy!");
    }
}
