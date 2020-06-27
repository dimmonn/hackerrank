package algos.hackerrank.easy;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class BreakingTheRecords {
  static int[] breakingRecords(int[] scores) {
    int _max = 0;
    int _min = 0;
    int max = scores[0];
    int min = Integer.MAX_VALUE;
    for (int score : scores) {
      if (score > max) {
        max = score;
        _max++;
      }
      if (score < min) {
        min = score;
        _min++;
      }
    }
    return new int[] {_max, _min - 1};
  }
}
