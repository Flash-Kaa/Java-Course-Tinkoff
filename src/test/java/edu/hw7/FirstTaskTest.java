package edu.hw7;

import edu.hw7.task1.AtomicCounter;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FirstTaskTest {
    private FirstTaskTest() {
    }

    @Test
    void test() {
        int testCount = 100;
        int threadsCount = 100;
        int incrementsInThreadCount = 100000;

        for (int i = 0; i < testCount; i++) {
            AtomicCounter counter = new AtomicCounter();
            Runnable r = () -> {
                for (var j = 0; j < incrementsInThreadCount; j++) {
                    counter.increment();
                }
            };

            List<Thread> l = Stream.generate(() -> new Thread(r))
                .limit(threadsCount)
                .peek(Thread::start)
                .toList();

            for (var j : l) {
                try {
                    j.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            assertThat(counter.getValue()).isEqualTo(incrementsInThreadCount * threadsCount);
        }
    }
}
