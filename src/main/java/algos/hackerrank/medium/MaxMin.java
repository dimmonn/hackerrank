package algos.hackerrank.medium;

import java.util.Arrays;

public class MaxMin {
    static int maxMin(int k, int[] arr) {

        int result = Integer.MAX_VALUE;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length + 1 - k; i++) {

            if (result > Math.abs(arr[i] - arr[i + k - 1])) {
                result = Math.abs(arr[i] - arr[i + k - 1]);
            }
        }

        return result;
    }
}
