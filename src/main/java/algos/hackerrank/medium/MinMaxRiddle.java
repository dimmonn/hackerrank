package algos.hackerrank.medium;

import java.util.Arrays;
import java.util.Stack;

public class MinMaxRiddle {


    static long[] bruteForce(long[] arr) {

        long[] result = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            Stack<Long> mins = new Stack<>();
            for (int j = 0; j < arr.length - i; j++) {
                int index = j;
                long[] tmp = new long[i + 1];
                for (int k = 0; k < tmp.length; k++) {
                    tmp[k] = arr[index++];

                }
                long min = Arrays.stream(tmp).min().isPresent() ? Arrays.stream(tmp).min().getAsLong() : 0;
                if (!mins.isEmpty()) {
                    long max = Math.max(mins.pop(), min);
                    mins.push(max);
                } else {
                    mins.push(min);
                }

            }
            result[i] = mins.pop();
        }
        return result;
    }

    static long[] linear(long[] arr) {

        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            left[i] = -1;
            right[i] = arr.length;

        }
        Stack<Integer> s = new Stack<>();


        for (int i = 0; i < arr.length; ++i) {
            while (!s.empty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (!s.empty()) {
                left[i] = s.peek();
            }
            s.push(i);
        }

        while (!s.empty()) {
            s.pop();
        }

        for (int i = arr.length - 1; i >= 0; --i) {
            while (!s.empty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (!s.empty()) {
                right[i] = s.peek();
            }
            s.push(i);
        }
        long[] result = new long[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            long l = arr[i];
            int window = right[i] - left[i] - 1;
            result[window] = Math.max(result[window], l);
        }


        for (int i = arr.length - 1; i >= 1; i--) {
            result[i] = Math.max(result[i], result[i + 1]);
        }
        return Arrays.stream(result)
                .skip(1)
                .toArray();


    }

}
