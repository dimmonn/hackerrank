package algos.hackerrank.medium;

import java.util.*;

public class EmasSupercomputer {
  static int twoPluses(String[] grid) {
    List<Integer> result = new ArrayList<>();
    Set<Map<Map<Integer, Integer>, Integer>> cache = new HashSet<>();
    List<Map<Map<Integer, Integer>, Integer>> largeCrosses = new ArrayList<>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length(); j++) {
        if (grid[i].charAt(j) == 'G') {
          Map<Map<Integer, Integer>, Integer> cross = sumOfCurrentCross(grid, i, j);
          Map<Integer, Integer> index = new HashMap<>();
          Map<Map<Integer, Integer>, Integer> length = new HashMap<>();
          index.put(i, j);
          length.put(index, 0);
          cache.add(length);
          if (!cross.isEmpty()) {
            cache.add(cross);
          }
        }
      }
    }
    PriorityQueue<Map<Map<Integer, Integer>, Integer>> pQueue = setUpPq(cache);
    Map<Map<Integer, Integer>, Integer> biggest = addLowerSizeElementToTheQ(pQueue);
    largeCrosses.add(biggest);
    while (!pQueue.isEmpty()) {
      compareCrossesAlgorythn(result, largeCrosses, pQueue);
    }
    Optional<Integer> max = result.stream().max(Comparator.naturalOrder());
    if (max.isPresent()) {
      return max.get();
    }
    return 0;
  }

  private static void compareCrossesAlgorythn(
      List<Integer> result,
      List<Map<Map<Integer, Integer>, Integer>> largeCrosses,
      PriorityQueue<Map<Map<Integer, Integer>, Integer>> pQueue) {
    Map<Map<Integer, Integer>, Integer> item = addLowerSizeElementToTheQ(pQueue);
    int x1 = 0, y1 = 0;
    Set<Map<Integer, Integer>> coordinates = item.keySet();
    Optional<Map<Integer, Integer>> xy = coordinates.stream().findFirst();
    if (xy.isPresent()) {
      Map<Integer, Integer> _xy = xy.get();
      Optional<Integer> x = _xy.keySet().stream().findFirst();
      if (x.isPresent()) {
        x1 = x.get();
        y1 = _xy.get(x1);
      }
    }
    for (Map<Map<Integer, Integer>, Integer> largeCross : largeCrosses) {
      if (item.equals(largeCross)) {
        continue;
      }
      int r1 = 0;
      int _x1 = 0, _x2 = 0, _y1 = 0, _y2 = 0, length = 0;
      Optional<Map<Integer, Integer>> largeXY = largeCross.keySet().stream().findFirst();
      if (largeXY.isPresent()) {
        Map<Integer, Integer> _largeXY = largeXY.get();
        Optional<Integer> largeX = _largeXY.keySet().stream().findFirst();
        if (largeX.isPresent()) {
          int _largeX = largeX.get();
          length = largeCross.get(_largeXY);
          _x1 = _largeX - length;
          _x2 = _largeX + length;
          _y1 = _largeXY.get(_largeX) - length;
          _y2 = _largeXY.get(_largeX) + length;
          Optional<Integer> itemLength = item.values().stream().findFirst();
          if (itemLength.isPresent()) {
            r1 = itemLength.get();
          }
        }
      }
      if (isLowerCrossValid(x1, y1, r1, _x1, _x2, _y1, _y2, length)) {
        Optional<Integer> largeCrossLength = largeCross.values().stream().findFirst();
        int r2 = 0;
        if (largeCrossLength.isPresent()) {
          r2 = largeCrossLength.get();
        }
        int _r1 = r1 == 0 ? 1 : r1 * 4 + 1;
        int _r2 = r2 == 0 ? 1 : r2 * 4 + 1;
        result.add(_r1 * _r2);
      }
    }
    addCrossAndSortCollection(largeCrosses, item);
  }

  public static void addCrossAndSortCollection(
      List<Map<Map<Integer, Integer>, Integer>> largeCrosses,
      Map<Map<Integer, Integer>, Integer> item) {
    largeCrosses.add(item);
    largeCrosses.sort(
        (o1, o2) -> {
          Integer l1 = 0;
          for (Integer value : o1.values()) {
            l1 = value;
          }
          Integer l2 = 0;
          for (Integer value : o2.values()) {
            l2 = value;
          }
          return l2.compareTo(l1);
        });
  }

  private static boolean isLowerCrossValid(
      int x1, int y1, int r1, int _x1, int _x2, int _y1, int _y2, int length) {
    return ((x1 + r1 < _x1 + length && y1 - r1 > _y1 + length)
            || (x1 + r1 < _x1 + length && y1 + r1 < _y1 + length)
            || (x1 - r1 > _x1 + length && y1 + r1 < _y1 + length)
            || (x1 - r1 > _x1 + length && y1 - r1 > _y1 + length))
        || ((y1 > _y2 && y1 - r1 > _y1 + length && x1 != _x1 + length)
            || (x1 < _x1 && x1 + r1 < _x1 + length && y1 != _y1 + length)
            || (y1 < _y1 && y1 + r1 < _y1 + length && x1 != _x1 + length)
            || (x1 > _x2 && x1 - r1 > _x1 + length && y1 != _y1 + length));
  }

  private static Map<Map<Integer, Integer>, Integer> addLowerSizeElementToTheQ(
      PriorityQueue<Map<Map<Integer, Integer>, Integer>> pQueue) {
    Map<Map<Integer, Integer>, Integer> biggest = pQueue.poll();

    Optional<Integer> hasElement = biggest.values().stream().findFirst();
    if (hasElement.isPresent()) {
      int largestCache = hasElement.get();
      if (largestCache > 1) {
        Map<Map<Integer, Integer>, Integer> _tmp = new HashMap<>();
        _tmp.put(biggest.keySet().stream().findFirst().get(), --largestCache);
        pQueue.add(_tmp);
      }
    }
    return biggest;
  }

  private static PriorityQueue<Map<Map<Integer, Integer>, Integer>> setUpPq(
      Set<Map<Map<Integer, Integer>, Integer>> cache) {
    PriorityQueue<Map<Map<Integer, Integer>, Integer>> pQueue =
        new PriorityQueue<>(
            (o1, o2) -> {
              Integer l1 = 0;
              for (Integer value : o1.values()) {
                l1 = value;
              }
              Integer l2 = 0;
              for (Integer value : o2.values()) {
                l2 = value;
              }
              return l2.compareTo(l1);
            });
    pQueue.addAll(cache);
    return pQueue;
  }

  private static Map<Map<Integer, Integer>, Integer> sumOfCurrentCross(
      String[] grid, int i, int j) {
    boolean isCrossValid = true;
    int delta = 1;
    Map<Map<Integer, Integer>, Integer> sizeToCenter = new HashMap<>();
    while (isCrossValid) {
      if (i - delta >= 0
          && i + delta < grid.length
          && j - delta >= 0
          && j + delta < grid[i].length()) {
        if (grid[i - delta].charAt(j) == 'G'
            && grid[i + delta].charAt(j) == 'G'
            && grid[i].charAt(j + delta) == 'G'
            && grid[i].charAt(j - delta) == 'G') {
          Map<Integer, Integer> tmp = new HashMap<>();
          tmp.put(i, j);
          sizeToCenter.put(tmp, delta);
          delta++;
        } else {
          isCrossValid = false;
        }
      } else {
        isCrossValid = false;
      }
    }
    return sizeToCenter;
  }
}
