package edu.project3;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Terminal {
    private final static Logger LOGGER = LogManager.getLogger();
    private final static  Scanner SCANNER = new Scanner(System.in);
    private final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private Terminal() {
    }

    public static Request expectRequest() {
        while (true) {
            var request = SCANNER.nextLine();

            String[] r = request.split(" ");

            if (!firstCommandsCorrectness(r)) {
                continue;
            }

            var curInd = 4;
            URI uri;
            try {
                uri = new URI(r[curInd++]);
            } catch (URISyntaxException e) {
                LOGGER.info(String.format("Incorrect URI: %s", r[curInd - 1]));
                continue;
            }

            LocalDate from = LocalDate.MIN;
            LocalDate to = LocalDate.MAX;

            if (curInd < r.length - 1 && r[curInd].equals("--from")) {
                curInd++;
                try {
                    from = LocalDate.parse(r[curInd++], DATE_FORMATTER);
                } catch (DateTimeParseException e) {
                    LOGGER.info(String.format("Incorrect date '%s'", r[curInd - 1]));
                    continue;
                }
            }

            if (curInd < r.length - 1 && r[curInd].equals("--to")) {
                curInd++;
                try {
                    to = LocalDate.parse(r[curInd++], DATE_FORMATTER);
                } catch (DateTimeParseException e) {
                    LOGGER.info(String.format("Incorrect date '%s'", r[curInd - 1]));
                    continue;
                }
            }

            Request.ResultFormat format = null;

            if (curInd < r.length - 1 && r[curInd].equals("--format")) {
                curInd++;
                var formatStr = r[curInd++].toLowerCase();

                if (formatStr.equals("markdown")) {
                    format = Request.ResultFormat.MARKDOWN;
                } else if (formatStr.equals("adoc")) {
                    format = Request.ResultFormat.ADOC;
                } else {
                    LOGGER.info(String.format("Incorrect format '%s'", formatStr));
                    continue;
                }
            }

            if (curInd < r.length) {
                LOGGER.info("unexpected command");
                continue;
            }

            return new Request(uri, from, to, format);
        }
    }

    private static boolean firstCommandsCorrectness(String[] command) {
        if (command.length < 5) {
            LOGGER.info("Incorrect command count");
            return false;
        }

        int curInd = 0;

        return checkCommand(command[curInd++], "java")
            && checkCommand(command[curInd++], "-jar")
            && checkCommand(command[curInd++], "nginx-log-stats.jar")
            && checkCommand(command[curInd], "--path");
    }

    private static boolean checkCommand(String actual, String expected) {
        if(!actual.equals(expected)) {
            LOGGER.info(String.format("Command '%s' not found, did you mean '%s'", actual, expected));
            return false;
        }

        return true;
    }
}
