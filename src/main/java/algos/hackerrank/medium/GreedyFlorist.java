package algos.hackerrank.medium;

import java.util.Arrays;

public class GreedyFlorist {
    static int getMinimumCost(int k, int[] c) {
        Arrays.sort(c);
        int i = c.length - 1;
        int bought = 0;
        int total = 0;
        //start backwards from the most expensive flower, stop when there is no more flowers left
        while (i >= 0) {
            //Calculate total
            //increment bought by 1 when everyone in the group has bought equal number of flowers
            for (int j = 0; j < k && i >= 0; j++) {
                total += (1 + bought) * c[i];
                i--;
            }
            bought++;
        }
        return total;
    }
}
