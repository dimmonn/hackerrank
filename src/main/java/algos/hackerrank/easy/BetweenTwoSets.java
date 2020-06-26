package algos.hackerrank.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BetweenTwoSets {
  public static int getTotalX(List<Integer> a, List<Integer> b) {
    // Write your code here
    int result = 0;
    Collections.sort(a);
    Collections.sort(b);
    int gcd = getMaxCommonDivisor(a);
    int lcd = getMinCommonDivisor(b);
    for (int i = gcd; i <= lcd; i += gcd) {
      if (lcd % i == 0 && i % gcd == 0) {
        result++;
      }
    }

    return result;
  }

  private static int getMinCommonDivisor(List<Integer> b) {
    int max = b.get(0);
    for (Integer high : b) {
      if (high % max != 0) {
        int tmp = high % max;
        while (tmp > 0) {
          max = tmp;
          tmp = high % tmp;
        }
      }
    }
    return max;
  }

  private static int getMaxCommonDivisor(List<Integer> a) {
    int min = 1;
    for (Integer low : a) {
      if (min % low != 0) {
        if (low % min == 0) {
          min = low;
        } else {
          min = (low % min) * min;
          if (min % low != 0) {
            min = low * min;
          }
        }
      }
    }
    return min;
  }
}
