package edu.hw10.firstTask;

import edu.hw10.task1.Max;
import edu.hw10.task1.Min;
import edu.hw10.task1.NotNull;

public record MyRecordWithAnnotations(
    @Min(0) int real,
    @Max(0) double doubl,
    @Min(0) @Max(10) int real2,
    @NotNull String str
) {
}
