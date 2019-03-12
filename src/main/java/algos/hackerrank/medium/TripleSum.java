package algos.hackerrank.medium;

import java.util.Arrays;

public class TripleSum {
    static long triplets(int[] a, int[] b, int[] c) {
        long result = 0;
        int[] _tmpB = Arrays.stream(b).sorted().distinct().toArray();
        int[] _tmpA = Arrays.stream(a).sorted().distinct().toArray();
        int[] _tmpC = Arrays.stream(c).sorted().distinct().toArray();

        for (int i1 : _tmpB) {
            int lowIndex_a = findLowIndex(i1, _tmpA, 0, _tmpA.length) + 1;
            int lowIndex_c = findLowIndex(i1, _tmpC, 0, _tmpC.length) + 1;
            result += (long) lowIndex_a * lowIndex_c;

        }
        return result;
    }

    private static int findLowIndex(int i1, int[] arr, int start, int end) {
        if (i1 >= arr[arr.length - 1]) {
            return arr.length - 1;
        }
        int middle = (start + end) / 2;

        if (start > end) {
            return -1;
        }
        if (arr[middle] > i1) {
            return findLowIndex(i1, arr, start, middle - 1);
        } else if (arr[middle] <= i1) {
            if (arr[middle + 1] > i1) {
                return middle;
            } else if (middle < arr.length - 2) {
                return findLowIndex(i1, arr, middle + 1, end);
            } else {
                return middle + 1;
            }
        } else {
            return middle;

        }
    }
}
