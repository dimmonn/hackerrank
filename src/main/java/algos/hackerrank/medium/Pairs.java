package algos.hackerrank.medium;

import java.util.HashMap;
import java.util.Map;

public class Pairs {
    static int pairs(int k, int[] arr) {
        int result = 0;
        Map<Integer, Integer> nums = new HashMap<>();
        for (int i : arr) {
            nums.put(i, nums.getOrDefault(i, 0) + 1);
        }
        for (int i1 : arr) {
            int val = Math.abs(i1 + k);
            if (nums.containsKey(val) && nums.get(val) > 0) {
                nums.put(val, nums.get(val) - 1);
                result++;
            }
        }
        return result;

    }

}