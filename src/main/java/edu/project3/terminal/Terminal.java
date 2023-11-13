package edu.project3.terminal;

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
    private final static Scanner SCANNER = new Scanner(System.in);
    private final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private Terminal() {
    }

    public static Logger getLogger() {
        return LOGGER;
    }

    public static TerminalRequest expectRequest() {
        while (true) {
            String request = SCANNER.nextLine();

            String[] commands = request.split(" ");

            if (!firstCommandsCorrectness(commands)) {
                continue;
            }

            int curInd = 4;
            URI uri;

            try {
                uri = new URI(commands[curInd++]);
            } catch (URISyntaxException e) {
                LOGGER.error(String.format("Incorrect URI: %s", commands[curInd - 1]));
                continue;
            }

            LocalDate from = null;
            LocalDate to = null;

            if (curInd < commands.length - 1 && commands[curInd].equals("--from")) {
                curInd++;
                try {
                    from = LocalDate.parse(commands[curInd++], DATE_FORMATTER);
                } catch (DateTimeParseException e) {
                    LOGGER.error(String.format("Incorrect date '%s'", commands[curInd - 1]));
                    continue;
                }
            }

            if (curInd < commands.length - 1 && commands[curInd].equals("--to")) {
                curInd++;
                try {
                    to = LocalDate.parse(commands[curInd++], DATE_FORMATTER);
                } catch (DateTimeParseException e) {
                    LOGGER.error(String.format("Incorrect date '%s'", commands[curInd - 1]));
                    continue;
                }
            }

            TerminalRequest.ResultFormat format = null;

            if (curInd < commands.length - 1 && commands[curInd].equals("--format")) {
                curInd++;
                var formatStr = commands[curInd++].toLowerCase();

                if (formatStr.equals("markdown")) {
                    format = TerminalRequest.ResultFormat.MARKDOWN;
                } else if (formatStr.equals("adoc")) {
                    format = TerminalRequest.ResultFormat.ADOC;
                } else {
                    LOGGER.error(String.format("Incorrect format '%s'", formatStr));
                    continue;
                }
            }

            if (curInd < commands.length) {
                LOGGER.error("unexpected command");
                continue;
            }

            return new TerminalRequest(uri, from, to, format);
        }
    }

    private static boolean firstCommandsCorrectness(String[] command) {
        if (command.length < 5) {
            LOGGER.error("Incorrect command count");
            return false;
        }

        int curInd = 0;

        return checkCommand(command[curInd++], "java")
            && checkCommand(command[curInd++], "-jar")
            && checkCommand(command[curInd++], "nginx-log-stats.jar")
            && checkCommand(command[curInd], "--path");
    }

    private static boolean checkCommand(String actual, String expected) {
        if (!actual.equals(expected)) {
            LOGGER.error(String.format("Command '%s' not found, did you mean '%s'", actual, expected));
            return false;
        }

        return true;
    }
}
