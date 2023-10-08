package hw_1;

import org.intellij.lang.annotations.MagicConstant;

public class Task1 {
    private Task1() {
    }

    @MagicConstant
    public static int minutesToSeconds(String time) {
        var time1 = time.split(":");

        return Integer.parseInt(time1[0]) * 60 + Integer.parseInt(time1[1]);
    }
}
