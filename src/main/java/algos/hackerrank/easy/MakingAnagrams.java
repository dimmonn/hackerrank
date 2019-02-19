package algos.hackerrank.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MakingAnagrams {
    static int makeAnagram(String a, String b) {
        char[] s1 = a.toCharArray();
        Arrays.sort(s1);
        char[] s2 = b.toCharArray();
        Arrays.sort(s2);
        char[] smallest;
        char[] biggest;
        if (s1[0] < s2[0]) {
            smallest = s1;
            biggest = s2;
        } else {
            smallest = s2;
            biggest = s1;
        }
        Map<Character,Integer> big = new HashMap<>();
        Map<Character,Integer> small = new HashMap<>();
        for (int i = 0; i < biggest.length; i++) {
            big.put(biggest[i],big.getOrDefault(biggest[i],0)+1);

        }
        for (int i = 0; i < smallest.length; i++) {
            small.put(smallest[i],small.getOrDefault(smallest[i],0)+1);

        }
        small.forEach((k,v)->big.merge(k,v,(v1,v2)->v1-v2));
        return big.values().stream().mapToInt(i -> Math.abs(i.intValue())).sum();
    }

}
