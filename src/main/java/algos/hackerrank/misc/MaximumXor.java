package algos.hackerrank.misc;


public class MaximumXor {

  static class BitTree {
    BitTree one;
    BitTree zero;

    BitTree write(boolean v) {
      if (v) {
        if (one == null) {
          one = new BitTree();
        }
        return one;
      } else {
        if (zero == null) {
          zero = new BitTree();
        }
        return zero;
      }
    }
  }

  // Complete the maxXor function below.
  static int[] maxXor(int[] arr, int[] queries) {
    final BitTree tree = new BitTree();
    for (int v : arr) {
      BitTree h = tree;
      for (int b = 0; b < 32; ++b) {
        h = h.write((v & 0x80000000) != 0);
        v = v << 1;
      }
    }

    int result[] = new int[queries.length];
    for (int i = 0; i < queries.length; ++i) {
      int q = queries[i];
      int v = 0;
      BitTree h = tree;
      for (int b = 0; b < 32; ++b) {
        v = v << 1;
        if ((q & 0x80000000) == 0) {
          // Not inverted. Follow high.
          if (h.one != null) {
            h = h.one;
            v |= 1;
          } else {
            h = h.zero;
          }
        } else {
          // Inverted. Follow low.
          if (h.zero != null) {
            h = h.zero;
            v |= 1;
          } else {
            h = h.one;
          }
        }
        q= q << 1;
      }
      result[i] = v;
    }

    return result;
  }

  public static void main(String[] args) {

    System.out.println(Integer.toBinaryString(Integer.MIN_VALUE>>>26));
    System.out.println(Integer.MIN_VALUE>>1);
    int[] a = new int[]{Integer.MAX_VALUE/2, Integer.MAX_VALUE/3, Integer.MAX_VALUE/4};
    int[] b = new int[]{3, 7, 2};
    System.out.println(~5);
    System.out.println(Integer.toBinaryString(5));
    System.out.println(Integer.toBinaryString(-6));
    maxXor(a, b);

  }
}
