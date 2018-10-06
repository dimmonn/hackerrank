package algos.hackerrank;

public class RepeatedString {
    static long repeatedString(String s, long n) {
        long as = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                as++;
            }
        }
        long fold = n / s.length();
        int complete = (int) (n % s.length());
        int half = 0;
        if (s.length() < n) {
            for (int i = 0; i < complete; i++) {
                if (s.charAt(i) == 'a') {
                    half++;
                }
            }

            return half + as * fold;
        } else {
            long l = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'a') {
                    l++;
                }
            }
            return l;
        }
    }
}
