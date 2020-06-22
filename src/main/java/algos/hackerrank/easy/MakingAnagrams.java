package algos.hackerrank.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MakingAnagrams {
    static int makeAnagram(String a, String b) {
        char[] s1 = a.toCharArray();
        char[] s2 = b.toCharArray();
        Map<Character, Integer> first = new HashMap<>();
        Map<Character, Integer> second = new HashMap<>();
        for (char c : s1) {
            first.put(c, first.getOrDefault(c, 0) + 1);
        }
        for (char c : s2) {
            second.put(c, second.getOrDefault(c, 0) + 1);
        }
        second.forEach((k, v) -> first.merge(k, v, (v1, v2) -> v1 - v2));
        return first.values().stream().mapToInt(i -> Math.abs(i.intValue())).sum();
    }

    public static List<Integer> stringAnagram(List<String> dictionary, List<String> query) {
        List<Integer> result = new ArrayList<>();
        List<Map<Character, Integer>> queries = anagramListToListOfMapDuplicates(query);
        Map<Map<Character, Integer>, Integer> dicts = anagramListToMapOfDuplicates(dictionary);
        for (Map<Character, Integer> _q : queries) {
            if (dicts.get(_q) != null) {
                result.add(dicts.get(_q));
            } else {
                result.add(0);
            }
        }

        return result;
    }

    private static List<Map<Character, Integer>> anagramListToListOfMapDuplicates(List<String> query) {
        List<Map<Character, Integer>> queries = new ArrayList<>();
        for (String anagram : query) {
            Map<Character, Integer> _query = new HashMap<>();
            for (int i = 0; i < anagram.length(); i++) {
                _query.put(anagram.charAt(i), _query.getOrDefault(anagram.charAt(i) + 1, 0) + 1);
            }
            queries.add(_query);
        }
        return queries;
    }

    private static Map<Map<Character, Integer>, Integer> anagramListToMapOfDuplicates(List<String> dictionary) {
        Map<Map<Character, Integer>, Integer> dicts = new HashMap<>();
        for (String anagram : dictionary) {
            Map<Character, Integer> _dicts = new HashMap<>();
            for (int i = 0; i < anagram.length(); i++) {
                _dicts.put(anagram.charAt(i), _dicts.getOrDefault(anagram.charAt(i), 0) + 1);
            }
            dicts.put(_dicts, dicts.getOrDefault(_dicts, 0) + 1);
        }
        return dicts;
    }
}



