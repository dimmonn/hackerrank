package algos.hackerrank.medium.abbreviation;

import java.util.Stack;

public class Particle {
    private Stack<Character> a;
    private Stack<Character> b;

    public Particle(char[] a, char[] b) {
        this.a = parseToStack(a);
        this.b = parseToStack(b);

    }

    public String aToB(Stack<Character> a, Stack<Character> b) {
        if (b.isEmpty()) {
            return "YES";
        }
        if (("" + a.peek()).equals("" + b.peek()) && Character.isUpperCase(a.peek())) {
            a.pop();
            b.pop();
            aToB(a, b);
        } else if (("" + a.peek()).equals("" + b.peek()) && Character.isLowerCase(a.peek()) || Character.isUpperCase(b.peek()) && Character.isLowerCase(a.peek()) && ("" + a.peek()).equals("" + Character.toLowerCase(b.peek()))) {
            a.pop();
            aToB(a, b);
            b.pop();
            aToB(a, b);
        } else if (("" + Character.toLowerCase(b.peek())).equals("" + a.peek())) {
            a.pop();
            aToB(a, b);
            b.pop();
            aToB(a, b);
        }
        return "NO";
    }

    private static Stack<Character> parseToStack(char[] b1) {
        Stack<Character> stackOfChars = new Stack<>();
        for (int i = b1.length - 1; i >= 0; i--) {
            char c = b1[i];
            stackOfChars.push(c);
        }
        return stackOfChars;
    }
}
