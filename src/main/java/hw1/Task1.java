package hw1;

import org.jetbrains.annotations.NotNull;

public class Task1 {
    private Task1() {
    }

    public static int minutesToSeconds(String time) {
        var time1 = time.split(":");

        return Integer.parseInt(time1[0]) * 60 + Integer.parseInt(time1[1]);
    }
}
