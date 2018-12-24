package algos.hackerrank.easy;

import java.util.Arrays;

public class LeftRotation {

    static int[] rotLeft(int[] a, int d) {

        int[] result = new int[a.length];
        int delta = d - d / a.length;
        int count = 0;
        int[] left = Arrays.copyOfRange(a, 0, delta);
        int[] right = Arrays.copyOfRange(a, delta, a.length);
        for (int i = 0; i < right.length; i++) {
            result[i] = right[i];
            count++;
        }
        for (int aLeft : left) {
            result[count++] = aLeft;
        }
        return result;
    }

}
