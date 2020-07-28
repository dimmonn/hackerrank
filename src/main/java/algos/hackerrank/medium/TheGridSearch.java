package algos.hackerrank.medium;

import java.util.*;

public class TheGridSearch {
  static String gridSearch(String[] G, String[] P) {
    Map<Integer, Set<Integer>> indexes = new HashMap<>();
    Stack<String> compare = new Stack<>();
    Stack<String> compareBackup = new Stack<>();
    buildStack(P, compare);
    buildStack(P, compareBackup);
    for (int i = 0; i < G.length; i++) {
      String g = G[i];
      if (compare.isEmpty()) {
        break;
      }
      String peek = compare.peek();
      if (g.contains(peek)) {
        if (compare.size() == P.length) {
          indexes.clear();
        }
        setupIndex(indexes, compare, i, g, peek);
      } else {
        resetStack(compare, compareBackup);
        String _peek = compare.peek();
        if (g.contains(_peek)) {
          setupIndex(indexes, compare, i, g, _peek);
        }
      }
    }
    if (ifKeysAreLessThenOneDiff(indexes)) {
      return "NO";
    }
    Map<Integer, Integer> result = setUpCommonElementsStructure(indexes);
    if (ifTheSamePositionStartsPTimesThenYes(P, result)) {
      return "YES";
    }
    return "NO";
  }

  private static boolean ifKeysAreLessThenOneDiff(Map<Integer, Set<Integer>> indexes) {
    List<Integer> keys = new ArrayList<>(indexes.keySet());
    Collections.sort(keys);
    Integer first = keys.get(0);
    for (int i = 1; i < keys.size(); i++) {
      if (first + 1 != keys.get(i)) {
        return true;
      }
      first += 1;
    }
    return false;
  }

  private static boolean ifTheSamePositionStartsPTimesThenYes(
      String[] P, Map<Integer, Integer> result) {
    for (Integer integer : result.keySet()) {
      if (result.get(integer) == P.length) {
        return true;
      }
    }
    return false;
  }

  private static Map<Integer, Integer> setUpCommonElementsStructure(
      Map<Integer, Set<Integer>> indexes) {
    Collection<Set<Integer>> values = indexes.values();
    Map<Integer, Integer> result = new HashMap<>();
    for (Set<Integer> value : values) {
      for (Integer integer : value) {
        result.put(integer, result.getOrDefault(integer, 0) + 1);
      }
    }
    return result;
  }

  private static void buildStack(String[] P, Stack<String> _compare) {
    for (int i = P.length - 1; i >= 0; i--) {
      String s = P[i];
      _compare.push(s);
    }
  }

  private static void resetStack(Stack<String> compare, Stack<String> _compare) {
    compare.clear();
    compare.addAll(_compare);
  }

  private static void setupIndex(
      Map<Integer, Set<Integer>> indexes, Stack<String> compare, int i, String g, String _peek) {
    indexes.put(i, buildIndexes(g, _peek));
    compare.pop();
  }

  private static Set<Integer> buildIndexes(String g, String p) {
    Set<Integer> indexes = new HashSet<>();
    Set<Character> _p = new HashSet<>();
    for (char c : p.toCharArray()) {
      _p.add(c);
    }
    if (_p.size() == 1) {
      int prev = 0;
      while (!g.isEmpty()) {
        int index = g.indexOf(p);
        if (index == 0) {
          g = g.substring(1);
          indexes.add(prev++);
        } else if (index == -1) {
          return indexes;
        } else {
          g = g.substring(index);
          prev += index;
          indexes.add(prev);
        }
      }
      return indexes;
    }

    int prevIndex = 0;
    while (!g.isEmpty() && g.contains(p)) {
      prevIndex = prevIndex == 0 ? g.indexOf(p) : prevIndex + p.length() + g.indexOf(p);
      indexes.add(prevIndex);
      int beginIndex = prevIndex + p.length();
      if (beginIndex < g.length()) {
        g = g.substring(beginIndex);
      } else {
        return indexes;
      }
    }
    return indexes;
  }
}
