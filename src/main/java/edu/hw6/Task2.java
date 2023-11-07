package edu.hw6;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task2 {
    private Task2() {
    }

    public static void cloneFile(Path path) throws IOException {
        if(Files.notExists(path)) {
            throw new IllegalArgumentException();
        }

        int copyNumber = 0;
        Path copyPath = path;
        String fileName = path.getFileName().toString();
        String fileExtension = "";

        int extensionIndex = fileName.lastIndexOf(".");
        if (extensionIndex > 0) {
            fileExtension = fileName.substring(extensionIndex);
            fileName = fileName.substring(0, extensionIndex);
        }

        while (Files.exists(copyPath)) {
            copyNumber++;
            String copyName = fileName + " — копия";
            if (copyNumber > 1) {
                copyName += " (" + copyNumber + ")";
            }
            copyName += fileExtension;

            copyPath = Paths.get(path.getParent().toString(), copyName);
        }

        Files.copy(path, copyPath);
    }
}
