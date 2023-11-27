package edu.hw9;

import edu.hw9.task2.Task2;
import java.io.File;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SecondTaskTest {
    private SecondTaskTest() {
    }

    @Test
    void testDirSearch() {
        List<String> dirList = List.of("src", "main", "java", "edu");
        StringBuilder sb = new StringBuilder();
        for (String dirName : dirList) {
            sb.append(dirName).append(File.separator);
        }

        List<String> expected = List.of(
            "hw4"
        );

        List<File> actual = Task2.findDirs(new File(sb.toString()), 20);
        assertThat(actual.size()).isEqualTo(expected.size());

        for (int i = 0; i < actual.size(); i++) {
            assertThat(actual.get(i).getPath().endsWith(expected.get(i))).isTrue();
        }
    }

    @Test
    void testFileSearch() {
        List<String> dirList = List.of("src", "main", "java", "edu", "project2");
        StringBuilder sb = new StringBuilder();
        for (String dirName : dirList) {
            sb.append(dirName).append(File.separator);
        }

        List<String> expected = List.of(
            "Maze.java",
            "GeneratorDFS.java",
            "RecursiveBacktrackerGenerator.java",
            "CustomRenderer.java",
            "SolverDFS.java",
            "SolverBFS.java"
        );

        List<File> actual = Task2.findFiles(new File(sb.toString()), 1000, 2800, ".java");
        assertThat(actual.size()).isEqualTo(expected.size());

        for (int i = 0; i < actual.size(); i++) {
            assertThat(actual.get(i).getPath().endsWith(expected.get(i))).isTrue();
        }
    }
}
