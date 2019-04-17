package algos.hackerrank.medium;

import java.util.HashMap;
import java.util.Map;

public class DavisStaircase {

    public static Map<Integer, Integer> cache = new HashMap<>();

    static int stepPerms(int n) {

        if (cache.get(n) != null) {
            return cache.get(n);
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        if (cache.get(n)==null) {
            int count = stepPerms(n - 1) + stepPerms(n - 2) + stepPerms(n - 3);
            cache.put(n,count);
        }
        return cache.get(n);

    }
}