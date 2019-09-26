package algos.hackerrank.hard;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class PoisonousPlants {
    static int result = 0;

    static int poisonousPlants(int[] p) {
        Set<Integer> cache = new HashSet<>();
        for (int i = 0; i < p.length - 1; i++) {
            if (p[i] < p[i + 1]) {
                cache.add(i + 1);
            }
        }
        if (cache.size() == 0) {
            return result;
        }
        int[] tmp = new int[p.length - cache.size()];
        for (int i = 0, k = 0; i < p.length; i++) {
            int i1 = p[i];
            if (cache.contains(i)) {
            } else {
                tmp[k++] = i1;
            }
        }
        result++;
        poisonousPlants(tmp);
        return result;

    }

    static int poisonousPlants4(int[] p) {
        List<LinkedList<Integer>> stack = new LinkedList<>();
        sortUpSubStacks(p, stack);
        int result = 0;
        int _tmp = 0;
        List<Integer> cache1 = new ArrayList<>();
        List<Integer> cache2 = new ArrayList<>();
        for (int i = 1; i < stack.size(); i++) {
            LinkedList<Integer> pre = stack.get(i - 1);
            LinkedList<Integer> current = stack.get(i);
            if ((current.size() == 0 ? _tmp : current.peekFirst()) > (pre.size() == 0 ? _tmp : pre.peekLast())) {
                Integer poll = current.poll();
                if (current.size() == 0 && poll != null) {
                    _tmp = poll;
                    cache1.add(i);
                }
            } else {
                cache2.add(i);
            }
            if (stack.size() == 1) {
                return result;
            }
            if (i == stack.size() - 1) {
                int offset = 0;
                for (int j = 0; j < cache2.size(); j++) {
                    LinkedList<Integer> mergeMe = stack.get(cache2.get(j) - 1 - j);
                    if (mergeMe.size() == 0) {
                        break;
                    }
                    Queue<Integer> removed = stack.remove(cache2.get(j) - j);
                    mergeMe.addAll(removed);
                    offset++;
                    if (stack.size() == 1) {
                        return result;
                    }
                }
                int final_tmp = offset;
                List<Integer> collect = cache1.stream().map(e -> e - ((e > final_tmp) ? final_tmp : e)).collect(Collectors.toList());
                followUpOnRemovedItems(stack, collect);
                cache1.clear();
                cache2.clear();
                result++;
                i = 0;
            }
        }
        return result;
    }

    private static void sortUpSubStacks(int[] p, List<LinkedList<Integer>> stack) {
        Queue<Integer> tmp = new LinkedList<>();
        for (int i = 0; i < p.length; i++) {
            if (i < p.length - 1 && p[i] < p[i + 1]) {
                tmp.offer(p[i]);
                stack.add(new LinkedList<>(tmp));
                tmp.clear();
                continue;
            } else if (i == p.length - 1) {
                tmp.offer(p[i]);
                stack.add(new LinkedList<>(tmp));
                tmp.clear();
                continue;
            }
            tmp.add(p[i]);
        }
    }

    private static void followUpOnRemovedItems(List<LinkedList<Integer>> stack, List<Integer> collect) {
        for (int j = 0; j < collect.size(); j++) {
            stack.remove(collect.get(j).intValue());
            if (j < collect.size() - 1) {
                collect.set(j + 1, collect.get(j + 1) - (j + 1));
            }
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
       /* int[] ints = Files.readAllLines(Path.of("/Users/dpolishc/Downloads/test.log")).
                stream().map(e -> e.split(" ")).flatMap(Arrays::stream).mapToInt(Integer::parseInt).toArray();
        System.out.println(poisonousPlants4(ints));*/
    }
}
