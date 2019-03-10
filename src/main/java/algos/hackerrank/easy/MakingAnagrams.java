package algos.hackerrank.easy;

import java.util.HashMap;
import java.util.Map;

public class MakingAnagrams {
    static int makeAnagram(String a, String b) {
        char[] s1 = a.toCharArray();
        char[] s2 = b.toCharArray();
        Map<Character,Integer> first = new HashMap<>();
        Map<Character,Integer> second = new HashMap<>();
        for (char c : s1) {
            first.put(c, first.getOrDefault(c, 0) + 1);

        }
        for (char c : s2) {
            second.put(c, second.getOrDefault(c, 0) + 1);

        }
        second.forEach((k,v)->first.merge(k,v,(v1,v2)->v1-v2));
        return first.values().stream().mapToInt(i -> Math.abs(i.intValue())).sum();
    }

}
