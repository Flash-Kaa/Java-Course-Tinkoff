package edu.hw5.task1;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

public class Task1 {
    private final static int MINUTES_IN_HOUR = 60;
    private final static int DATE_INDEX = 0;
    private final static int TIME_INDEX = 1;
    private final static int HOUR_INDEX = 1;
    private final static int MINUTE_INDEX = 1;
    private final static int DAY_INDEX = 2;

    private Task1() {
    }

    public static LocalTime calculateAverageSessionDurationInMinutes(List<String> sessions) {
        long averageTimeInMinutes = sessions.stream()
            .reduce(
                0L,
                (acc, session) -> {
                    String[] time = session.split(" - ");
                    return acc + getDuration(time[1])
                        .minus(getDuration(time[0]))
                        .toMinutes();
                },
                Long::sum
            ) / sessions.size();

        return LocalTime.of(
            (int) (averageTimeInMinutes / MINUTES_IN_HOUR),
            (int) (averageTimeInMinutes % MINUTES_IN_HOUR)
        );
    }

    private static Duration getDuration(String dateTime) {
        String[] dt = dateTime.split(", ");
        String[] date = dt[DATE_INDEX].split("-");
        String[] time = dt[TIME_INDEX].split(":");

        return Duration.ofDays(Integer.parseInt(date[DAY_INDEX]))
            .plusHours(Integer.parseInt(time[HOUR_INDEX]))
            .plusMinutes(Integer.parseInt(time[MINUTE_INDEX]));
    }
}
