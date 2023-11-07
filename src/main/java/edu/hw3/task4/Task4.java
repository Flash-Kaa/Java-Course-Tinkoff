package edu.hw3.task4;

import java.util.List;
import java.util.Map;

public class Task4 {
    private static final int ROMAN_I = 1;
    private static final int ROMAN_V = 5;
    private static final int ROMAN_X = 10;
    private static final int ROMAN_L = 50;
    private static final int ROMAN_C = 100;
    private static final int ROMAN_D = 500;
    private static final int ROMAN_M = 1000;
    private static final int MIN_ROMAN_NUMBER_IN_ARABIC = 1;
    private static final int MAX_ROMAN_NUMBER_IN_ARABIC = 3999;

    private static final Map<Integer, String> ARABIC_IN_ROMAN = Map.of(
        ROMAN_I, "I",
        ROMAN_V, "V",
        ROMAN_X, "X",
        ROMAN_L, "L",
        ROMAN_C, "C",
        ROMAN_D, "D",
        ROMAN_M, "M"
    );

    private Task4() {
    }

    public static String convertToRoman(int num) {
        if (num < MIN_ROMAN_NUMBER_IN_ARABIC || num > MAX_ROMAN_NUMBER_IN_ARABIC) {
            throw new IllegalArgumentException();
        }

        StringBuilder result = new StringBuilder();
        List<Integer> romanDigitsInArabic = ARABIC_IN_ROMAN.keySet().stream().sorted().toList();
        int index = romanDigitsInArabic.size() - 1;
        int numForChange = num;

        while (numForChange > 0) {
            Integer prefixRomanDigitInArabic = getPrefixRomanDigitInArabicOrNull(romanDigitsInArabic, index);
            int curRomanDigitInArabic = romanDigitsInArabic.get(index);

            while (prefixRomanDigitInArabic != null && numForChange >= curRomanDigitInArabic - prefixRomanDigitInArabic
                || numForChange >= curRomanDigitInArabic) {
                if (prefixRomanDigitInArabic != null && numForChange < curRomanDigitInArabic) {
                    result.append(ARABIC_IN_ROMAN.get(prefixRomanDigitInArabic));
                    numForChange += prefixRomanDigitInArabic;
                }

                result.append(ARABIC_IN_ROMAN.get(curRomanDigitInArabic));
                numForChange -= curRomanDigitInArabic;
            }

            index--;
        }

        return result.toString();
    }

    private static Integer getPrefixRomanDigitInArabicOrNull(List<Integer> romanDigitsInArabic, int index) {
        Integer prefixRomanDigitInArabic = null;

        if (index % 2 == 0 && index >= 2) {
            prefixRomanDigitInArabic = romanDigitsInArabic.get(index - 2);
        } else if (index != 0) {
            prefixRomanDigitInArabic = romanDigitsInArabic.get(index - 1);
        }

        return prefixRomanDigitInArabic;
    }
}
