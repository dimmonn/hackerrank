package algos.hackerrank.medium;

import java.util.*;

public class FrequencyQueries {
    static List<Integer> freqQuery(List<int[]> queries) {
        List<Integer> integers = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> friequency = new HashMap<>();
        for (int[] list : queries) {
            if (list[0] == 1) {
                if (map.get(list[1]) != null) {
                    friequency.put(map.getOrDefault(list[1], 1), friequency.getOrDefault(map.get(list[1]), 2) - 1);
                }
                map.put(list[1], map.getOrDefault(list[1], 0) + 1);
                friequency.put(map.get(list[1]), friequency.getOrDefault(map.get(list[1]), 0) + 1);
            } else if (list[0] == 2 && map.get(list[1]) != null && map.get(list[1]) > 0) {
                friequency.put(map.getOrDefault(list[1], 1), friequency.getOrDefault(map.get(list[1]), 2) - 1);
                map.put(list[1], map.getOrDefault(list[1], 2) - 1);
                friequency.put(map.get(list[1]), friequency.getOrDefault(map.get(list[1]), 0) + 1);
            } else if (list[0] == 3) {
                if (friequency.get(list[1]) != null && friequency.get(list[1]) > 0) {
                    integers.add(1);
                } else {
                    integers.add(0);
                }
            }
        }
        return integers;
    }

}
