package algos.hackerrank.medium;

import java.util.*;

public class ClimbingTheLeaderboard {
  static int[] climbingLeaderboard(int[] scores, int[] alice) {
    int[] result = new int[alice.length];
    Set<Integer> _scores = new HashSet<>();
    for (int s : scores) {
      _scores.add(s);
    }
    List<Integer> scoreList = new ArrayList<>(_scores);
    Collections.sort(scoreList, Collections.reverseOrder());
    int[] _cache = new int[scoreList.size()];
    for (int i = 0; i < _cache.length; i++) {
      _cache[i] = scoreList.get(i);
    }
    int index = 0;
    for (Integer a : alice) {
      int idx = binarySearchtheMostClosedIndex(_cache, a);
      result[index++] = idx + 1;
    }
    return result;
  }

  private static int binarySearchtheMostClosedIndex(int[] scores, int aScrore) {
    return _binarySearchtheMostClosedIndex(scores, aScrore, 0, scores.length);
  }

  private static int _binarySearchtheMostClosedIndex(int[] scores, int aScrore, int from, int to) {
    int index = (from + to) / 2;
    if (to - from == 1) {
      if (scores[from] > aScrore) {
        return to;
      } else return from;
    }
    if (scores[index] < aScrore) {
      return _binarySearchtheMostClosedIndex(scores, aScrore, from, index);
    } else {
      return _binarySearchtheMostClosedIndex(scores, aScrore, index, to);
    }
  }
}
