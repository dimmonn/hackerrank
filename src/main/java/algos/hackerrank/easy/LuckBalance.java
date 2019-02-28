package algos.hackerrank.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LuckBalance {

    static int luckBalance(int k, int[][] contests) {

        List<Integer> maxes = new ArrayList<>();
        int result = 0;
        for (int[] contest : contests) {
            if (contest[1] == 1) {
                maxes.add(contest[0]);
            } else {
                result += contest[0];
            }
        }
        Collections.sort(maxes);
        if (maxes.size() > k) {
            for (int i = 0; i < maxes.size() - k; i++) {
                result -= maxes.get(i);

            }

        }
        int sum = 0;
        if (!maxes.isEmpty()) {
            List<Integer> integers = maxes.size() > k ? maxes.subList(maxes.size() - k, maxes.size()) : maxes;
            sum = integers.stream().mapToInt(e -> e).sum();
        }

        return result + sum;

    }
}
