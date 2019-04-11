package algos.hackerrank.medium;

import java.util.Arrays;

public class MaxArraySum {


    static int maxSubsetSum(int[] arr) {

        int maximum = Arrays.stream(arr).max().getAsInt();
        if (maximum < 0) {
            return maximum;
        }
        int current = 0, tmp = 0, two = 0;
        for (int i = 0; i < arr.length; i++) {
            tmp = current;
            current = Math.max(arr[i] + two, tmp);
            two = tmp;
        }
        return Math.max(current, two);

    }

}