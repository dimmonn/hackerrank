package algos.hackerrank.medium;

import java.util.*;

public class BiggerIsGreater {
  static String biggerIsGreater(String w) {
    if (w.length() == 1) {
      return "no answer";
    }
    char[] chars = w.toCharArray();
    for (int i = chars.length - 1; i >= 0; i--) {
      int prevIdx = i - 1;
      if (prevIdx < 0) {
        break;
      }
      int toIdx = chars.length - 1;
      if (maximize(prevIdx, i, toIdx, chars)) {
        Arrays.sort(chars, i, toIdx + 1);
        break;
      }
    }
    String result = new String(chars);
    if (result.equals(w)) {
      return "no answer";
    }
    return result;
  }

  private static boolean maximize(int prevIdx, int fromIdx, int toIdx, char[] mapperCopy) {
    boolean flag = false;
    int prev = mapperCopy[prevIdx];
    for (int i = fromIdx; i <= toIdx; i++) {
      int i1 = mapperCopy[i];
      if (i1 > prev) {
        int i2 = mapperCopy[prevIdx];
        mapperCopy[prevIdx] = (char) i1;
        mapperCopy[i] = (char) i2;
        flag = true;
      }
    }
    return flag;
  }
}
