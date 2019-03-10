package algos.hackerrank.medium;

public class SpecialPalindromeAgain {
    static long substrCount(int n, String s) {
        long result = 0;
        for (int i = 0; i < n; i++) {
            StringBuilder substringToCheckForPalindrome = new StringBuilder();
            substringToCheckForPalindrome.append(s.charAt(i));
            inner:
            for (int j = i + 1; j < n; j++) {
                substringToCheckForPalindrome.append(s.charAt(j));
                int counter = 0;
                for (int k = 0; k < substringToCheckForPalindrome.length() / 2; k++) {
                    if (breakCondition(i, substringToCheckForPalindrome, counter, k)) {
                        break inner;
                    } else if (oneDiffCondition(substringToCheckForPalindrome, counter, k, 0)) {
                        counter++;
                    }
                }
                if (isPalindrome(substringToCheckForPalindrome.toString())) {
                    result++;
                }
            }
        }
        return result + s.length();
    }

    private static boolean oneDiffCondition(StringBuilder substringToCheckForPalindrome, int counter, int k, int i) {
        return substringToCheckForPalindrome.toString().charAt(k) !=
                substringToCheckForPalindrome.toString().charAt(substringToCheckForPalindrome.length() - k - 1)
                && counter == i;
    }

    private static boolean breakCondition(int i, StringBuilder substringToCheckForPalindrome, int counter, int k) {
        return (substringToCheckForPalindrome.toString().charAt(k) !=
                substringToCheckForPalindrome.toString().charAt(k + 1)
                && i < ((substringToCheckForPalindrome.length() / 2) - 1))
                || oneDiffCondition(substringToCheckForPalindrome, counter, k, 1);
    }

    static boolean isPalindrome(String s) {

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - i - 1]
                    || (chars[i] != chars[i + 1] && chars.length > 3 && i < (chars.length / 2) - 1)
            ) {
                return false;
            }
        }
        return true;
    }

}
