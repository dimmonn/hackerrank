package algos.hackerrank.hard;

public class ArrayManipulation {
    static long arrayManipulation(int n, int[][] queries) {
        long[] zeros = new long[n];
        long max = Long.MIN_VALUE;
        for (int[] query : queries) {
            int a = query[0] - 1;
            int b = query[1] - 1;
            int c = query[2];
            zeros[a] += c;

            if (b + 1 < n) {
                zeros[b + 1] -= c;
            }

        }

        for (int i = 1; i < zeros.length; i++) {
            zeros[i] += zeros[i - 1];
            max = Math.max(zeros[i], max);
        }
        return max;
    }

}

