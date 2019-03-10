package algos.hackerrank.advansed;

import java.util.Arrays;

public class ReverseShuffleMerge {
    static String reverseShuffleMerge(String s) {
        char[] sorted = s.substring(0,s.length()/2).toCharArray();
        Arrays.sort(sorted);
        String result = new String(sorted);

        return result;
    }

}
