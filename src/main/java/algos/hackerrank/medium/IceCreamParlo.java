package algos.hackerrank.medium;

import java.util.HashMap;
import java.util.Map;

public class IceCreamParlo {
    static void whatFlavors(int[] cost, int money) {
        Map<Integer, Integer> integers = new HashMap();
        for (int i = 0; i < cost.length; i++) {
            int i1 = cost[i];
            integers.put(i1, i);
        }
        for (int i = 0; i < cost.length; i++) {
            int i1 = cost[i];
            if (integers.get(money - i1) != null && integers.get(money - i1)  != i) {
                System.out.println((i + 1) + " " + (integers.get(money - i1) + 1));
                return;
            }
        }
    }
}
