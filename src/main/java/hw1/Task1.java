package hw1;

public class Task1 {
    private Task1() {
    }

    @SuppressWarnings("MagicNumber")
    public static int minutesToSeconds(String time) {
        var time1 = time.split(":");

        return Integer.parseInt(time1[0]) * 60 + Integer.parseInt(time1[1]);
    }
}
