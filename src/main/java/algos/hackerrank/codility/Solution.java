package algos.hackerrank.codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static int solution(int N, String S) {


        //
        int result = 0;

        if (S.isEmpty()) {
            return 2 * N;
        }
        String[] acronims = S.split(" ");

        List<String> strings = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "J", "K"));

        List<List<Integer>> sections = new ArrayList<>();
        Pattern p = Pattern.compile("\\d+");


        for (int i = 1; i <= N; i++) {
            List<Integer> integers = new ArrayList<>();
            for (int j = 0; j < acronims.length; j++) {
                String acronim = acronims[j];
                Matcher matcher = p.matcher(acronim);
                while (matcher.find()) {
                    String number = matcher.group(0);
                    if (Integer.valueOf(number) == i) {
                        String letter = acronim.replace(number, "");

                        for (int k = 0; k < strings.size(); k++) {
                            if (strings.get(k).equals(letter)) {
                                integers.add(k + 1);
                            }

                        }

                    }
                }
                if ((integers.contains(4) || integers.contains(5) || integers.contains(6)) && integers.size() == 1) {

                    result += 1;
                }


            }
        }
        //
        return result;
    }


    public static void main(String[] args) {

        System.out.println(true && false);


    }


}
