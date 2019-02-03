package algos.hackerrank.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyQueries {
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> integers = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> friequency = new HashMap<>();

        queries.forEach(list -> {
            if (list.get(0) == 1) {
                map.put(list.get(1), map.getOrDefault(list.get(1), 0) + 1);
                friequency.put(map.get(list.get(1)),
                        friequency.getOrDefault(
                                map.get(list.get(1)), 0) + 1);
            } else if (list.get(0) == 2) {

                if (map.get(list.get(1)) != null && map.get(list.get(1)) != 0) {
                    map.put(list.get(1), map.get(list.get(1)) - 1);

                    if (map.get(list.get(1)) != 0) {
                        friequency.put(
                                map.get(list.get(1)),
                                friequency.get(map.get(list.get(1))) - 1);
                    }

                } else if (map.get(list.get(1)) != null && map.get(list.get(1)) == 0) {
                    map.remove(list.get(1));


                }
            } else {
                System.out.println(friequency);
                if (friequency.get(list.get(1)) != null) {
                    integers.add(1);
                } else {
                    integers.add(0);
                }
            }
        });


        return integers;
    }

    public static void main(String[] args) {

    }
}
