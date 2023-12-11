package edu.hw6;

import edu.hw6.task3.AbstractFilter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ThirdTaskTest {
    private final static Map<Path, Boolean> PATH_WITH_EXPECTED_FILTER_RESULT = Map.of(
        Path.of("src/main/java/edu/hw1/Task0.java"), false,
        Path.of("src/main/java/edu/hw1/Task1.java"), true,
        Path.of("src/main/java/edu/hw1/Task2.java"), false,
        Path.of("src/main/java/edu/hw1/Task3.java"), true,
        Path.of("src/main/java/edu/hw1/Task4.java"), false,
        Path.of("src/main/java/edu/hw1/Task5.java"), true,
        Path.of("src/main/java/edu/hw1/Task6.java"), false,
        Path.of("src/main/java/edu/hw1/Task7.java"), true,
        Path.of("src/main/java/edu/hw1/Task8.java"), true
    );

    private ThirdTaskTest() {
    }

    @Test
    void testFilterSize() {
        AbstractFilter filter = AbstractFilter.smallerThan(1500).and(AbstractFilter.largerThan(800));
        try {
            for (var i : PATH_WITH_EXPECTED_FILTER_RESULT.keySet()) {
                assertThat(filter.accept(i)).isEqualTo(PATH_WITH_EXPECTED_FILTER_RESULT.get(i));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testExtension() {
        AbstractFilter filter = AbstractFilter.hasExtension("xml").or(AbstractFilter.regexContains("^[mvnw]{3}"));

        try {
            assertThat(filter.accept(Path.of("README.md"))).isFalse();
            assertThat(filter.accept(Path.of("mvnw.cmd"))).isTrue();
            assertThat(filter.accept(Path.of("mvnw"))).isTrue();
            assertThat(filter.accept(Path.of("pom.xml"))).isTrue();
            assertThat(filter.accept(Path.of(".gitignore"))).isFalse();
            assertThat(filter.accept(Path.of("checkstyle.xml"))).isTrue();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testWritableAndReadable() {
        AbstractFilter filter = AbstractFilter.readable().and(AbstractFilter.writable());
        try {
            for (var i : PATH_WITH_EXPECTED_FILTER_RESULT.keySet()) {
                assertThat(filter.accept(i)).isTrue();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
