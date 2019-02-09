package algos.hackerrank.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MarkAndToys {

    static int maximumToys(int[] prices, int k) {
        List<Integer> toys = new ArrayList<>();
        Arrays.sort(prices);
        int sum = 0;
        for (int price : prices) {
            if (sum > k) {
                return toys.size();
            } else if (sum + price <= k) {
                toys.add(price);
                sum += price;
            }

        }

        return toys.size();

    }

}
