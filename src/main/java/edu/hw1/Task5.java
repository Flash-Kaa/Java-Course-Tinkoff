package edu.hw1;

public class Task5 {
    private Task5() {
    }

    public static boolean isPalindromeDescendant(int number) {
        String numberAsString = Integer.toString(number);
        boolean isPalindrome = isPalindrome(numberAsString);

        while (!isPalindrome && numberAsString.length() > 1) {
            numberAsString = findDescendantNumber(numberAsString);
            isPalindrome = isPalindrome(numberAsString);
        }

        return isPalindrome && numberAsString.length() > 1;
    }

    private static String findDescendantNumber(String numberParent) {
        int numberParentLength = numberParent.length();
        StringBuilder descendantNumber = new StringBuilder();

        for (int i = 0; i < numberParentLength; i += 2) {
            // number is odd and its last loop
            if (i == numberParentLength - 1) {
                descendantNumber.append(numberParent.charAt(i) - '0');
                break;
            }

            descendantNumber.append(numberParent.charAt(i) + numberParent.charAt(i + 1) - 2 * '0');
        }

        return descendantNumber.toString();
    }

    private static boolean isPalindrome(String numberAsString) {
        int numberLen = numberAsString.length();

        for (int i = 0; i < numberLen / 2; i++) {
            if (numberAsString.charAt(i) != numberAsString.charAt(numberLen - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
