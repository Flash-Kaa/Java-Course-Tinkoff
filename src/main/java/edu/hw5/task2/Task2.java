package edu.hw5.task2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Task2 {
    private static final int MONTH_IN_YEAR = 12;
    private static final int DAY_FOR_TASK = 13;

    private Task2() {
    }

    public static List<LocalDate> findFridaysOn13ths(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DATE, DAY_FOR_TASK);

        List<LocalDate> res = new ArrayList<>();

        for (int month = 0; month < MONTH_IN_YEAR; month++) {
            calendar.set(Calendar.MONTH, month);

            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                res.add(LocalDate.of(year, month + 1, DAY_FOR_TASK));
            }
        }

        return res;
    }

    public static LocalDate findNextFriday13th(LocalDate startDate) {
        LocalDate nextFriday = startDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));

        while (nextFriday.getDayOfMonth() != DAY_FOR_TASK) {
            nextFriday = nextFriday.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        }

        return nextFriday;
    }
}
