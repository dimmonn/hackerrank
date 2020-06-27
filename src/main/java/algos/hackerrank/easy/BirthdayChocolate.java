package algos.hackerrank.easy;

import java.util.ArrayList;
import java.util.List;

public class BirthdayChocolate {
  static int birthday(List<Integer> s, int d, int m) {
    int result = 0;
    for (int i = 0; i < s.size() - m; i++) {
      int ways = 0;
      for (int j = i; j < i + m; j++) {
        ways += s.get(j);
      }
      if (ways == d) {
        result++;
      }
    }
    return result;
  }
}
