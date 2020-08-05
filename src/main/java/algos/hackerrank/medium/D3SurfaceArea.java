package algos.hackerrank.medium;

public class D3SurfaceArea {
  static int surfaceArea(int[][] A) {
    int area = 0;
    for (int i = 0; i < A.length; i++) {
      int[] ints = A[i];
      for (int j = 0; j < ints.length; j++) {
        int current = ints[j];
        int ahead = j + 1 < ints.length ? ints[j + 1] : 0;
        int right = i + 1 < A.length ? A[i + 1][j] : 0;
        int behind = j - 1 >= 0 ? ints[j - 1] : 0;
        int left = i - 1 >= 0 ? A[i - 1][j] : 0;
        if (current > ahead) {
          area += current - ahead;
        }
        if (current > behind) {
          area += current - behind;
        }
        if (current > left) {
          area += current - left;
        }
        if (current > right) {
          area += current - right;
        }
      }
    }
    return area + 2 * A.length * A[0].length;
  }
}
