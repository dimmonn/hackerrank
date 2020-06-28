package algos.hackerrank.easy;

import java.util.*;

public class MigratoryBirds {
  static int migratoryBirds(List<Integer> arr) {
    int result = Integer.MAX_VALUE;
    Map<Integer, Integer> cache = new HashMap<>();
    int max = 0;
    for (Integer num : arr) {
      Integer value = cache.getOrDefault(num, 0);
      cache.put(num, value + 1);
        if (cache.getOrDefault(num, 0) > max) {
            max = cache.getOrDefault(num, 0);
        }
    }
    for (Integer num : cache.keySet()) {
      if (cache.get(num) == max) {
        if (result > num) {
          result = num;
        }
      }
    }
    return result;
  }
}
