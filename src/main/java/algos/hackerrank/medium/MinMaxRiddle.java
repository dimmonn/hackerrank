package algos.hackerrank.medium;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Stack;

public class MinMaxRiddle {
    static long[] riddle(long[] arr) {

        long[] result = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            Stack<Long> mins = new Stack<>();
            for (int j = 0; j < arr.length-i; j++) {
                int index = j;
                long[] tmp = new long[i + 1];
                for (int k = 0; k < tmp.length; k++) {
                    tmp[k] = arr[index++];

                }
                long min = Arrays.stream(tmp).min().getAsLong();
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

    public static void main(String[] args) throws IOException {

        long[] perf = Files.readLines(new File("/Users/dpolishc/Downloads/test.log"), Charset.defaultCharset()).stream().
                map(e -> e.split(" ")).
                flatMap(x -> Arrays.stream(x)).mapToLong(e -> Long.parseLong(e)).toArray();
        long[] riddle1 = riddle(perf);

    }
}
