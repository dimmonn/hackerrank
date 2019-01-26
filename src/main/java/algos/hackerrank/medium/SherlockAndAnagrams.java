package algos.hackerrank.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SherlockAndAnagrams {

    static int sherlockAndAnagrams(String s) {

        int resSingle = 0;
        char[] input = s.toCharArray();
        Map<String, Integer> allSortedSubstrings = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            StringBuilder tmp = new StringBuilder();
            tmp.append(input[i]);
            Integer singleChar = allSortedSubstrings.getOrDefault(String.valueOf(input[i]), 0) + 1;
            allSortedSubstrings.put(String.valueOf(input[i]), singleChar);
            for (int j = i; j < input.length - 1; j++) {
                tmp.append(input[j + 1]);
                char[] chars = tmp.toString().toCharArray();
                Arrays.sort(chars);
                Integer fewChars = allSortedSubstrings.getOrDefault(new String(chars), 0);
                allSortedSubstrings.put(new String(chars), fewChars + 1);
            }
        }
        for (Map.Entry<String, Integer> single : allSortedSubstrings.entrySet()) {
            for (int i = single.getValue(); i > 0; i--) {
                resSingle = resSingle + i - 1;
            }
        }
        return resSingle;
    }

}