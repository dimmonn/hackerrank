package algos.hackerrank.misc;

public class FlippingBits {

  static long badFlippingBits(long n) {

    String s = Long.toUnsignedString(n, 2);
    StringBuilder sb = new StringBuilder(s);
    sb.reverse();
    int abs = Math.abs(sb.length() - 32);
    for (int i = 0; i < abs; i++) {
      sb.append(0);

    }
    sb.reverse();
    String replace = sb.toString().replace('0', '2').replace('1', '0').replace('2', '1');

    return Long.parseUnsignedLong(replace, 2);
  }

  static long flippingBits(long n) {
    return (long) Math.pow(2, 32) - 1 - n;
  }

}
