package algos.hackerrank.easy;

import java.util.HashSet;
import java.util.Set;

public class TwoStrings {
    static String twoStrings(String s1, String s2) {

        char[] chars1;
        char[] chars2;
        Set<Character> characters1 = new HashSet<>();
        if (s1.length() <= s2.length()) {
            chars1 = s2.toCharArray();
            chars2 = s1.toCharArray();

        } else {
            chars1 = s1.toCharArray();
            chars2 = s2.toCharArray();

        }

        for (char aChar : chars1) {
            characters1.add(aChar);
        }


        for (char c : chars2) {
            if (characters1.contains(c)) {
                return "YES";
            }
        }
        return "NO";
    }
}
