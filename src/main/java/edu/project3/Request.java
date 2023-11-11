package edu.project3;

import java.net.URI;
import java.time.LocalDate;

public record Request(URI uri, LocalDate filterFrom, LocalDate filterTo, ResultFormat resultFormat) {
    public enum ResultFormat {
        MARKDOWN, ADOC
    }
}
