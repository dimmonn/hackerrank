package algos.hackerrank.medium;

import java.util.*;

public class NonDivisibleSubset {
  public static int nonDivisibleSubset(int k, List<Integer> s) {
    int result = 0;
    int remaining[] = new int[k];
    for (int i = 0; i < s.size(); i++) {
      remaining[s.get(i) % k]++;
      System.out.println();
    }
    for (int i = 1; i <= k / 2; i++) {
      if (i == k - i && remaining[i] != 0) {
        result++;
        continue;
      }
      result += Math.max(remaining[i], remaining[k - i]);
    }
    result = remaining[0] > 0 ? ++result : result;
    return result;
  }
}
// 1 7 2 4
