package algos.hackerrank.medium;

import java.util.*;

public class TheBombermanGame {
  static String[] bomberMan(int n, String[] grid) {
    if (n == 1) {
      return grid;
    }
    if (n % 2 == 0) {
      String[] filledGrid = new String[grid.length];
      for (int i = 0; i < grid.length; i++) {
        StringBuilder _tmp = new StringBuilder();
        for (int j = 0; j < grid[i].length(); j++) {
          _tmp.append("O");
        }
        filledGrid[i] = _tmp.toString();
      }

      return filledGrid;
    }
    int count = countOddsBeforeN(n);
    Set<Map<Integer, Integer>> helper = new HashSet<>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length(); j++) {
        Map<Integer, Integer> asys = new HashMap<>();
        asys.put(i, j);
        helper.add(asys);
      }
    }
    Set<Map<Integer, Integer>> bombs = findBombs(grid);
    Set<Map<Integer, Integer>> swap = new HashSet<>();
    Map<Integer, Set<Map<Integer, Integer>>> cache = new HashMap<>();
    buildUpCache(grid, helper, bombs, swap, cache);
    swap = count % 2 != 0 ? cache.get(2) : cache.get(5);
    String[] result = buildUpResult(grid, swap);
    return result;
  }

  private static void buildUpCache(
      String[] grid,
      Set<Map<Integer, Integer>> helper,
      Set<Map<Integer, Integer>> bombs,
      Set<Map<Integer, Integer>> swap,
      Map<Integer, Set<Map<Integer, Integer>>> cache) {
    for (int i = 1; i <= 5; i++) {
      if (i % 3 == 2) {
        swap = bombsToBeBlown(grid, helper, bombs);
        cache.put(i, swap);
      } else if (i % 3 == 0) {
        bombs = swap;
      }
    }
  }

  private static String[] buildUpResult(String[] grid, Set<Map<Integer, Integer>> swap) {
    String[] result = new String[grid.length];
    for (int i = 0; i < grid.length; i++) {
      StringBuilder _result = new StringBuilder();
      for (int j = 0; j < grid[i].length(); j++) {
        Map<Integer, Integer> tmp = new HashMap<>();
        tmp.put(i, j);
        if (swap.contains(tmp)) {
          _result.append("O");
        } else _result.append(".");
      }
      result[i] = _result.toString();
    }
    return result;
  }

  private static int countOddsBeforeN(int n) {
    int count = 0;
    for (int i = 3; i <= n; i += 2) {
      count++;
    }
    return count;
  }

  private static Set<Map<Integer, Integer>> bombsToBeBlown(
      String[] grid, Set<Map<Integer, Integer>> helper, Set<Map<Integer, Integer>> bombs) {
    Set<Map<Integer, Integer>> _helper = new HashSet<>(helper);
    Set<Map<Integer, Integer>> bombsExpanded = new HashSet<>();
    for (Map<Integer, Integer> bomb : bombs) {
      for (Integer x : bomb.keySet()) {
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        Map<Integer, Integer> up = new HashMap<>();
        Map<Integer, Integer> down = new HashMap<>();
        Map<Integer, Integer> current = new HashMap<>();
        if (x - 1 >= 0) {
          left.put(x - 1, bomb.get(x));
          bombsExpanded.add(left);
        }
        if (x + 1 < grid.length) {
          right.put(x + 1, bomb.get(x));
          bombsExpanded.add(right);
        }
        if (bomb.get(x) + 1 < grid[0].length()) {
          up.put(x, bomb.get(x) + 1);
          bombsExpanded.add(up);
        }
        if (bomb.get(x) - 1 >= 0) {
          down.put(x, bomb.get(x) - 1);
          bombsExpanded.add(down);
        }
        current.put(x, bomb.get(x));
        bombsExpanded.add(current);
      }
    }
    _helper.removeAll(bombsExpanded);
    return _helper;
  }

  private static Set<Map<Integer, Integer>> findBombs(String[] grid) {
    Set<Map<Integer, Integer>> cache = new HashSet<>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length(); j++) {
        if (grid[i].charAt(j) == 'O') {
          Map<Integer, Integer> tmp = new HashMap<>();
          tmp.put(i, j);
          cache.add(tmp);
        }
      }
    }
    return cache;
  }
}
