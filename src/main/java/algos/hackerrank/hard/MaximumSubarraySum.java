package algos.hackerrank.hard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class MaximumSubarraySum {


    static long maximumSum(long[] a, long m) {
        List<Long> prefix = new ArrayList<>();
        TreeSet<Long> searcher = new TreeSet<>();
        long sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum = (sum + a[i] % m) % m;
            prefix.add(sum);
        }
        Long result = prefix.get(0);
        searcher.add(result);
        for (int i = 1; i < prefix.size(); i++) {
            long currentSum = prefix.get(i);
            Long nearestHighterThenCurrent = searcher.higher(currentSum);
            if (nearestHighterThenCurrent != null) {
                result = Math.max((currentSum - nearestHighterThenCurrent + m) % m, result);
            } else {
                result = Math.max(currentSum, result);
            }
            searcher.add(currentSum);
        }
        return result;
    }
}
