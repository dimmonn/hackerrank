package algos.hackerrank.hard;

public class MakingCandies {


    static long minimumPasses(long m, long w, long p, long n) {

        long simpleStepsTotal = tooManyMwOrPriceTooHigh(m, w, p, n);
        if (simpleStepsTotal != 0) return simpleStepsTotal;
        long maxMW = Math.max(m, w);
        long minMW = Math.min(m, w);
        long totalSteps = Long.MAX_VALUE;
        long candies = 0;
        long tmpCandiesZeros = 0;
        for (long i = 1; i < Long.MAX_VALUE; i++) {
            candies = tmpCandiesZeros == 0 ? candies + minMW * maxMW : tmpCandiesZeros;
            tmpCandiesZeros = 0;
            totalSteps = getSimpleSteps(n, maxMW, minMW, totalSteps, candies, i, n - candies);
            long money = candies / p;
            if (money == 0 && (candies + minMW * maxMW) / p == 0) {
                long k = i;
                i = skipZeros(i, k, p, candies, minMW, maxMW);
                tmpCandiesZeros = candies + (minMW * maxMW) * (i - k);
                i--;
                continue;
            } else {
                for (int j = 0; j < money; j++) {
                    if (minMW < maxMW) {
                        minMW++;
                        long tmpC = candies - ((j + 1) * p);
                        totalSteps = getSimpleSteps(n, maxMW, minMW, totalSteps, candies, i, n - tmpC);
                    } else {
                        maxMW++;
                        if (n / minMW <= maxMW || n / maxMW <= minMW) {
                            return i + 2 >= totalSteps ? totalSteps : i + 2;
                        }
                        long tmpC = candies - ((j + 1) * p);
                        totalSteps = getSimpleSteps(n, maxMW, minMW, totalSteps, candies, i, n - tmpC);
                    }

                }
            }
            candies -= money * p;
        }
        return 0;
    }

    private static long tooManyMwOrPriceTooHigh(long m, long w, long p, long n) {
        if (Long.MAX_VALUE / m <= w || Long.MAX_VALUE / w <= m || m * w >= n) {
            return 1;
        } else if (p >= n) {
            long simpleStepsTotal = (n - m * w) / (m * w);
            return n > 2 * m * w && (double) (n - m * w) % (m * w) == 0 ? 1 + simpleStepsTotal : 2 + simpleStepsTotal;
        }
        return 0;
    }

    private static long skipZeros(long steps, long tmp, long price, long candies, long minMW, long maxMW) {

        steps = steps + ((price - candies) / (minMW * maxMW));
        return steps;
    }

    private static long getSimpleSteps(long n, long maxMW, long minMW, long totalSteps, long candies, long i, long l) {
        long stepsSimple = (n - candies) > (maxMW * minMW) && (double) (l) % (maxMW * minMW) == 0 ? (l) / (maxMW * minMW) : 1 + (l) / (maxMW * minMW);
        totalSteps = stepsSimple + i >= totalSteps ? totalSteps : stepsSimple + i;
        return totalSteps;
    }
}