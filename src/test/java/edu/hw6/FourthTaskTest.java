package edu.hw6;

import edu.hw6.task4.Task4;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FourthTaskTest {
    private FourthTaskTest() {
    }

    @Test
    void testPhraseInFile() {
        var file = new File("test.txt");
        try {
            Task4.printPhraseInFile(file.toPath());
        } catch (Exception e) {
            deleteFile(file);
            throw new RuntimeException(e);
        }

        StringBuilder sb = new StringBuilder();

        try (FileInputStream reader = new FileInputStream(file)) {
            byte[] bytes = reader.readAllBytes();

            for (byte b : bytes) {
                sb.append((char) b);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            deleteFile(file);
        }

        assertThat(sb.toString())
            .isEqualTo("Programming is learned by writing programs. - Brian Kernighan");
    }

    private void deleteFile(File file) {
        try {
            Files.deleteIfExists(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
