package edu.hw5;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

public class Task1 {
    private Task1() {
    }

    private final static int MINUTES_IN_HOUR = 60;

    public static LocalTime calculateAverageSessionDurationInMinutes(List<String> sessions) {
        var timeInMinutes = sessions.stream().reduce(0L, (acc, session) -> {
            var time = session.split(" - ");
            return acc + getDuration(time[1])
                .minus(getDuration(time[0]))
                .toMinutes();
        }, Long::sum) / sessions.size();

        return LocalTime.of((int) (timeInMinutes / MINUTES_IN_HOUR), (int) (timeInMinutes % MINUTES_IN_HOUR));
    }

    private static Duration getDuration(String datetime) {
        var dt = datetime.split(", ");
        var date = dt[0].split("-");
        var time = dt[1].split(":");

        return Duration.ofDays(Integer.parseInt(date[2]))
            .plusHours(Integer.parseInt(time[0]))
            .plusMinutes(Integer.parseInt(time[1]));
    }
}
