package algos.hackerrank.medium;

public class FormingAmagicSquare {
  static int formingMagicSquare(int[][] s) {
    int result = Integer.MAX_VALUE;

    int[][] allPossibilities =
        new int[][] {
          {8, 1, 6}, {3, 5, 7}, {4, 9, 2}, {6, 1, 8}, {7, 5, 3}, {2, 9, 4}, {4, 9, 2}, {3, 5, 7},
          {8, 1, 6}, {2, 9, 4}, {7, 5, 3}, {6, 1, 8}, {8, 3, 4}, {1, 5, 9}, {6, 7, 2}, {4, 3, 8},
          {9, 5, 1}, {2, 7, 6}, {6, 7, 2}, {1, 5, 9}, {8, 3, 4}, {2, 7, 6}, {9, 5, 1}, {4, 3, 8}
        };
    for (int i = 0; i < allPossibilities.length; i += 3) {
      int[] l1 = allPossibilities[i];
      int[] l2 = allPossibilities[i + 1];
      int[] l3 = allPossibilities[i + 2];
      int s0 = getStatePlus90(s, l1, l2, l3, 0, 0, 0, 1, 2, 1, 2, 2);
      int s90 = getStatePlus90(s, l1, l2, l3, 2, 0, 1, 0, 0, 2, 1, 2);
      int s180 = getStatePlus90(s, l1, l2, l3, 2, 2, 2, 1, 0, 1, 0, 0);
      int s270 = getStatePlus90(s, l1, l2, l3, 0, 2, 1, 2, 2, 0, 1, 0);
      int min = Math.min(Math.min(s0, s90), Math.min(s180, s270));
      result = Math.min(result, min);
    }
    return result;
  }

  private static int getStatePlus90(
      int[][] s,
      int[] l1,
      int[] l2,
      int[] l3,
      int i2,
      int i3,
      int i4,
      int i5,
      int i6,
      int i7,
      int i8,
      int i9) {
    return Math.abs(l1[0] - s[i2][i3])
        + Math.abs(l1[1] - s[i4][i5])
        + Math.abs(l1[2] - s[i3][i6])
        + Math.abs(l2[0] - s[i7][i4])
        + Math.abs(l2[1] - s[1][1])
        + Math.abs(l2[2] - s[i5][i8])
        + Math.abs(l3[0] - s[i9][i2])
        + Math.abs(l3[1] - s[i8][i7])
        + Math.abs(l3[2] - s[i6][i9]);
  }

  public static void main(String[] args) {
    int[][] square1 = new int[][] {{7, 6, 5}, {7, 2, 8}, {5, 3, 4}};
    System.out.println(formingMagicSquare(square1));
    int[][] square2 = new int[][] {{6, 4, 6}, {9, 9, 3}, {9, 9, 7}};
    // System.out.println(formingMagicSquare(square2));
  }
}
/*
pre = [
        [[8, 1, 6], [3, 5, 7], [4, 9, 2]],
        [[6, 1, 8], [7, 5, 3], [2, 9, 4]],
        [[4, 9, 2], [3, 5, 7], [8, 1, 6]],
        [[2, 9, 4], [7, 5, 3], [6, 1, 8]],
        [[8, 3, 4], [1, 5, 9], [6, 7, 2]],
        [[4, 3, 8], [9, 5, 1], [2, 7, 6]],
        [[6, 7, 2], [1, 5, 9], [8, 3, 4]],
        [[2, 7, 6], [9, 5, 1], [4, 3, 8]],
        ]*/
