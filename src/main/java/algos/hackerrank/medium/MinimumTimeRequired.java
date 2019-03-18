package algos.hackerrank.medium;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class MinimumTimeRequired {


    static long minTime(long[] machines, long goal) {
        Arrays.sort(machines);
        long max = machines[0] * goal;
        long min = machines[0] * goal / machines.length;
        while (min < max - 1) {
            long mid = (max + min) / 2;
            if (goal > Arrays.stream(machines).map(i -> mid / i).sum()) {
                min = mid;
            } else max = mid;
        }
        return max;
    }


    public static void main(String[] args) throws IOException {
        long[] ints = Files.lines(Paths.get("src/main/resources/test.txt"))
                .map(e -> e.split(" ")).flatMap(x -> Arrays.stream(x)).mapToLong(Integer::parseInt).toArray();
        System.out.println(minTime(ints, 844676607));
    }
}

