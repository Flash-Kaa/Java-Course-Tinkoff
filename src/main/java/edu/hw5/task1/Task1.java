package edu.hw5.task1;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

public class Task1 {
    private final static int MINUTES_IN_HOUR = 60;

    private Task1() {
    }

    public static LocalTime calculateAverageSessionDurationInMinutes(List<String> sessions) {
        long averageTimeInMinutes = sessions.stream().reduce(0L, (acc, session) -> {
            String[] time = session.split(" - ");
            return acc + getDuration(time[1])
                .minus(getDuration(time[0]))
                .toMinutes();
        }, Long::sum) / sessions.size();

        return LocalTime.of(
            (int) (averageTimeInMinutes / MINUTES_IN_HOUR),
            (int) (averageTimeInMinutes % MINUTES_IN_HOUR)
        );
    }

    private static Duration getDuration(String datetime) {
        String[] dt = datetime.split(", ");
        String[] date = dt[0].split("-");
        String[] time = dt[1].split(":");

        return Duration.ofDays(Integer.parseInt(date[2]))
            .plusHours(Integer.parseInt(time[0]))
            .plusMinutes(Integer.parseInt(time[1]));
    }
}
