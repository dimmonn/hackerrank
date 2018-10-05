package algos.hackerrank;

import java.util.*;

public class SockMerchant {
    static int sockMerchant(int n, int[] ints) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, Arrays.stream(ints).boxed().toArray(Integer[]::new));

        Collections.sort(list);
        System.out.println(list);
        int[] result = new int[]{0};
        Stack<Integer> stack = new Stack<>();

        list.forEach(e -> {

            if (stack.size() != 0 && stack.peek().equals(e)) {
                stack.pop();
                result[0]++;
            } else {
                stack.push(e);
            }
        });
        return result[0];
    }
}
