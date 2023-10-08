package hw_1;

public class Task5 {
    private Task5() {
    }

    public static boolean isPalindromeDescendant(int number) {
        var str = Integer.toString(number);
        var isPalindrome = isPalindrome(str);

        while (!isPalindrome && str.length() > 1) {
            str = findChild(str);
            isPalindrome = isPalindrome(str);
        }

        return isPalindrome && str.length() > 1;
    }

    private static String findChild(String parent) {
        var parentStrLen = parent.length();
        var child = new StringBuilder();

        for (var i = 0; i < parentStrLen; i += 2) {

            // number is odd and its last loop
            if (i == parentStrLen - 1) {
                child.append(parent.charAt(i) - '0');
                break;
            }

            child.append(parent.charAt(i) + parent.charAt(i + 1) - 2 * '0');
        }

        return child.toString();
    }

    private static boolean isPalindrome(String number) {
        var numberLen = number.length();
        var isPalindrome = true;

        for (var i = 0; i < numberLen / 2; i++) {
            isPalindrome = number.charAt(i) == number.charAt(numberLen - i - 1);
            if (!isPalindrome) {
                return false;
            }
        }

        return true;
    }
}
