package edu.hw1;

public class Task7 {
    private Task7() {
    }

    private static final int BIT_DEPTH_OF_NUMBER = 2;

    public static int rotateLeft(int n, int shift) {
        if (shift < 0) {
            return rotateRight(n, -shift);
        }

        String binaryNumberAsString = Integer.toString(n, BIT_DEPTH_OF_NUMBER);
        int cuttingIndex = shift % binaryNumberAsString.length();
        String binaryNumberAsStringWithShift = swapPartsWithCutoutByIndex(binaryNumberAsString, cuttingIndex);

        return Integer.parseInt(binaryNumberAsStringWithShift, BIT_DEPTH_OF_NUMBER);
    }

    public static int rotateRight(int n, int shift) {
        if (shift < 0) {
            return rotateLeft(n, -shift);
        }

        String binaryNumberAsString = Integer.toString(n, BIT_DEPTH_OF_NUMBER);
        int cuttingIndex = binaryNumberAsString.length() - shift % binaryNumberAsString.length();
        String binaryNumberAsStringWithShift = swapPartsWithCutoutByIndex(binaryNumberAsString, cuttingIndex);

        return Integer.parseInt(binaryNumberAsStringWithShift, BIT_DEPTH_OF_NUMBER);
    }

    private static String swapPartsWithCutoutByIndex(String str, int cuttingIndex) {
        var firstPart = str.substring(0, cuttingIndex);
        var secondPart = str.substring(cuttingIndex);

        return secondPart + firstPart;
    }
}
