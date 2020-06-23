package algos.hackerrank.easy;

public class AppleAndOrange {
  static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
    int appleAtHome = getHomeFruits(s, t, a, apples);
    int orangeAtHome = getHomeFruits(s, t, b, oranges);
    System.out.println(appleAtHome);
    System.out.println(orangeAtHome);
  }

  private static int getHomeFruits(int s, int t, int b, int[] oranges) {
    int result = 0;
    for (int orange : oranges) {
      int _o = b + orange;
      if (_o >= s && _o <= t) {
        result++;
      }
    }
    return result;
  }
}
