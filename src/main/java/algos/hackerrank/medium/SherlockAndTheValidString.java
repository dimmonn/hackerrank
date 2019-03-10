package algos.hackerrank.medium;

import java.util.*;

public class SherlockAndTheValidString {

    static String isValid(String s) {
        if (s.length() == 1) {
            return "YES";
        }
        int[] chars = new int[26];
        char[] chars1 = s.toCharArray();

        for (int c : chars1) {
            chars[c - 'a']++;
        }
        Arrays.sort(chars);
        int zeroFinishedIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0) {
                zeroFinishedIndex = i;
                break;
            }

        }
        if (zeroFinishedIndex == 0) {
            return "NO";
        }
        int[] ints = Arrays.copyOfRange(chars, zeroFinishedIndex, chars.length);


        Map<Integer, Integer> integerIntegerMap = new HashMap<>();
        for (int anInt : ints) {
            integerIntegerMap.put(anInt, integerIntegerMap.getOrDefault(anInt, 0) + 1);

        }
        if (integerIntegerMap.size() > 2) {
            return "NO";
        }
        if (integerIntegerMap.size() == 1) {
            return "YES";
        }

        List<Map.Entry<Integer, Integer>> twoElementswithDiff = new ArrayList<>(integerIntegerMap.entrySet());
        Map.Entry<Integer, Integer> smallest = twoElementswithDiff.get(0).getValue() >
                twoElementswithDiff.get(1).getValue() ?
                twoElementswithDiff.get(1) : twoElementswithDiff.get(0);

        twoElementswithDiff.remove(smallest);
        Map.Entry<Integer, Integer> biggest = twoElementswithDiff.get(0);
        if (smallest.getKey() == 1 && smallest.getValue() == 1
                || smallest.getValue() == 1 && Math.abs(smallest.getKey() - biggest.getKey() - 1) == 0
        ) {
            return "YES";
        } else {
            return "NO";
        }


    }
}
