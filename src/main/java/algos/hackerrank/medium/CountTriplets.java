package algos.hackerrank.medium;

import java.util.*;

public class CountTriplets {

    //wrong
    static long countTriplets(List<Long> arr, long r) {
        int counter = 0;
        Stack<Integer> longs = new Stack<>();
        Collections.sort(arr);

        for (int i = 0; i < arr.size(); i++) {
            List<Long> longList = new ArrayList<>();
            if (i != 0 && Objects.equals(arr.get(i), arr.get(i - 1))) {
                continue;
            }
            if (longs.isEmpty() && arr.get(i) != 0) {
                longs.push(i);

            }
            int j = i + 1;
            while (j < arr.size()) {

                if (arr.get(j) / arr.get(longs.peek()) == r) {
                    longs.push(j);
                    if (longs.size() == 3) {

                        longs.pop();
                        if (!longList.isEmpty()) {
                            counter += longList.size();

                        }
                        counter++;
                    }
                } else if (arr.get(j) / arr.get(longs.peek()) == 1) {
                    longList.add(arr.get(j));

                }
                j++;
                if (j == arr.size()) {
                    longs.clear();
                }
            }
        }

        return counter;

    }

    //wrong
    static long countTriplets1(List<Long> arr, long r) {
        Set<Long> longsSet = new HashSet<>(arr);
        List<Long> noDups = new ArrayList<>(longsSet);
        Collections.sort(noDups);
        long counter = 0;
        Map<Long, Integer> dups = new HashMap<>();
        for (Long aLong : arr) {
            dups.merge(aLong, 1, (a, b) -> a + b);
        }
        if (r == 1) {
            long result = 0;
            for (Integer value : dups.values()) {
                result += (long) value * (value - 1) * (value - 2) / 6;
            }
            return result;

        }
        for (Long noDup : noDups) {
            if (longsSet.contains(noDup * r) && longsSet.contains(noDup * r * r)) {
                long first = (long) dups.get(noDup);
                long second = (long) dups.get(noDup * r);
                long third = (long) dups.get(noDup * r * r);
                counter += first * second * third;
            }

        }

        return counter;
    }


//correct
    static long _countTriplets(long[] arr, long r) {
        long cnt = 0;
        Map<Long, Long> map = new HashMap<>();
        Map<Long, Long> rMap = new HashMap<>();
        for (long n : arr) {
            if (n % r == 0) {
                long pre = n / r;
                Long cnt2 = rMap.get(pre);
                if (cnt2 != null) cnt += cnt2;

                Long cnt1 = map.get(pre);
                if (cnt1 != null) rMap.put(n, rMap.getOrDefault(n, 0L) + cnt1);
            }
            map.put(n, map.getOrDefault(n, 0L) + 1);
        }
        return cnt;
    }
}
