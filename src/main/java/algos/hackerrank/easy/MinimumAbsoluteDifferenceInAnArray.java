package algos.hackerrank.easy;

import java.util.Arrays;

public class MinimumAbsoluteDifferenceInAnArray {

    static int minimumAbsoluteDifference(int[] arr) {
        int result = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {

            int abs = Math.abs(arr[i] - arr[i + 1]);
            if (abs == 0) {
                return 0;
            }
            result = result < abs ? result : abs;

        }

        return result;

    }
}
