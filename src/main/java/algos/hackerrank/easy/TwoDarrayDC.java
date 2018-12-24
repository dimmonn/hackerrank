package algos.hackerrank.easy;

import java.util.*;

public class TwoDarrayDC {
    static int hourglassSum(int[][] arr) {


        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i < arr.length - 2 && j < arr[i].length - 2) {
                    int sum;
                    sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
                    sum = sum + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                    sum = sum + arr[i + 1][j + 1];
                    res.add(sum);
                }
            }
        }
        return Collections.max(res);
    }

}