package algos.hackerrank.easy;

import java.util.HashMap;
import java.util.Map;

public class CheckMagazine {
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        for (String word : magazine) {
            if (stringIntegerMap.get(word) == null) {
                stringIntegerMap.put(word, 1);

            } else {
                Integer value = stringIntegerMap.get(word);
                stringIntegerMap.put(word, ++value);
            }
        }

        for (String s : note) {
            if (stringIntegerMap.get(s) != null && stringIntegerMap.get(s) != 0) {
                Integer val = stringIntegerMap.get(s);
                val--;
                stringIntegerMap.put(s,val);
            } else {
                System.out.println("No");
            }
        }
        System.out.println("Yes");
    }
}
