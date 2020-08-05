package algos.hackerrank.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AbsolutePermutation {
  static int[] absolutePermutation(int n, int k) {
    Map<Integer, Set<Integer>> cache = new HashMap<>();
    Set<Integer> tmpCache = new HashSet<>();
    for (int i = 1; i <= n; i++) {
      Set<Integer> attachment = new HashSet<>();
      int greaterThenK, lessThenK = Math.abs(k + i);
      if (lessThenK <= n) {
        attachment.add(lessThenK);
        if (i <= k) {
          tmpCache.add(lessThenK);
        }
      }
      if (i > k) {
        greaterThenK = Math.abs(i - k);
        if (greaterThenK <= n && !tmpCache.contains(greaterThenK)) {
          if (attachment.isEmpty()) {
            int _tmpVal = greaterThenK;
            int position = Math.abs(k - greaterThenK);
            Set<Integer> setWith2Values = cache.get(position);
            removeExtra(k, cache, tmpCache, _tmpVal, position, setWith2Values);
          }
          attachment.add(greaterThenK);
        }
      }
      if (!attachment.isEmpty()) {
        cache.put(i, attachment);
        if (attachment.size() == 1) {
          tmpCache.addAll(attachment);
        }
      } else {
        return new int[] {-1};
      }
    }
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      Set<Integer> res = cache.get(i + 1);
      for (Integer re : res) {
        result[i] = re;
      }
    }
    return result;
  }

  private static void removeExtra(int k, Map<Integer, Set<Integer>> cache, Set<Integer> tmpCache, int _tmpVal, int position, Set<Integer> setWith2Values) {
    while (setWith2Values != null) {
      setWith2Values.remove(_tmpVal);
      for (Integer oneValueSet : setWith2Values) {
        _tmpVal = oneValueSet;
        tmpCache.add(_tmpVal);
      }
      if (position <= k) {
        break;
      }
      position = Math.abs(k - _tmpVal);
      setWith2Values = cache.get(position);
    }
  }
}
