package algos.hackerrank.easy;

public class BreakingTheRecords {
  static int[] breakingRecords(int[] scores) {
    int _max = 0;
    int _min = 0;
    int max = 0;
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
    return new int[] {_max - 1, _min - 1};
  }
}
