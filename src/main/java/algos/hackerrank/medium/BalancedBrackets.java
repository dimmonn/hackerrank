package algos.hackerrank.medium;

import java.util.Objects;
import java.util.Stack;

public class BalancedBrackets {
    static String isBalanced(String s) {
        if (s.length() % 2 != 0 || s.startsWith("}") || s.startsWith(")") || s.startsWith("]")
                || s.endsWith("{") || s.endsWith("(") || s.endsWith("[")) {
            return "NO";
        }
        Stack<String> brackets = new Stack<>();
        brackets.push(Character.toString(s.charAt(0)));
        for (int i = 1; i < s.length(); i++) {
            String pushed = Character.toString(s.charAt(i));
            if (pushed.equals("{") || pushed.equals("[") || pushed.equals("(")) {
                brackets.push(pushed);
                continue;
            }
            if (brackets.isEmpty()) {
                return "NO";
            }
            String peek = brackets.peek();
            String picked = brackets.isEmpty() ? null : peek;
            if ((pushed.charAt(0) - Objects.requireNonNull(picked).charAt(0)) < 3 && ((int) pushed.charAt(0) - picked.charAt(0)) > 0) {
                brackets.pop();
            } else {
                return "NO";
            }
        }
        return "YES";
    }
}


