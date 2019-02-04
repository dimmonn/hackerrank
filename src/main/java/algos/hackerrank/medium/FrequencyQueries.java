package algos.hackerrank.medium;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FrequencyQueries {
    static List<Integer> freqQuery(List<int[]> queries) {
        List<Integer> integers = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> friequency = new HashMap<>();

        for (int[] list : queries) {
            if (list[0] == 1) {

                if (map.get(list[1]) != null) {

                    friequency.put(map.getOrDefault(list[1], 1),
                            friequency.getOrDefault(
                                    map.get(list[1]), 2) - 1);
                }


                map.put(list[1], map.getOrDefault(list[1], 0) + 1);
                friequency.put(map.get(list[1]),
                        friequency.getOrDefault(
                                map.get(list[1]), 0) + 1);
            } else if (list[0] == 2) {

                if (map.get(list[1]) != null && map.get(list[1]) > 0) {

                    friequency.put(map.getOrDefault(list[1], 1), friequency.getOrDefault(map.get(list[1]), 2) - 1);


                    map.put(list[1], map.getOrDefault(list[1], 2) - 1);

                    friequency.put(map.get(list[1]), friequency.getOrDefault(map.get(list[1]), 0) + 1);
                }


            } else {

                if (friequency.get(list[1]) != null && friequency.get(list[1]) > 0) {
                    integers.add(1);
                } else {
                    integers.add(0);
                }
            }
        }

        return integers;
    }

    public static void main(String[] args) throws FileNotFoundException {


        List<int[]> myArray = new ArrayList<>();

        File file = new File("/Users/dpolishc/Downloads/test.txt");
        Scanner scanner = new Scanner(file);

        for (int row = 0; scanner.hasNextLine() && row < 10000; row++) {
            String[] s = scanner.nextLine().split(" ");
            int[] integers = new int[2];
            integers[0] = Integer.valueOf(s[0]);
            integers[1] = Integer.valueOf(s[1]);
            myArray.add(integers);
        }


        System.out.println();
        freqQuery(myArray);
    }


}
