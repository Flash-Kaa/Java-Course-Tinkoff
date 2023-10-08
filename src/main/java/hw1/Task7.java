package hw1;

public class Task7 {
    private Task7() {
    }

    public static int rotateLeft(int n, int shift) {
        if (shift < 0) {
            return rotateRight(n, -shift);
        }

        var binaryStr = Integer.toString(n, 2);
        var cutLength = shift % binaryStr.length();
        var binaryStrWithShift = swapParts(binaryStr, cutLength);

        return Integer.parseInt(binaryStrWithShift, 2);
    }

    public static int rotateRight(int n, int shift) {
        if (shift < 0) {
            return rotateLeft(n, -shift);
        }

        var binaryStr = Integer.toString(n, 2);
        var cutLength = binaryStr.length() - shift % binaryStr.length();

        var binaryStrWithShift = swapParts(binaryStr, cutLength);

        return Integer.parseInt(binaryStrWithShift, 2);
    }

    private static String swapParts(String str, int cutIndex) {
        var firstPart = str.substring(0, cutIndex);
        var secondPart = str.substring(cutIndex);

        return secondPart + firstPart;
    }
}
