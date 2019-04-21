package algos.hackerrank.medium;

import java.util.Stack;

public class AtaleOfTwoStacks {
    private static class MyQueue<T> {
        Stack<T> in = new Stack<>();
        Stack<T> out = new Stack<>();

        void enqueue(T element) {
            in.push(element);
        }

        T dequeue() {
            if (!out.isEmpty()) {
                return out.pop();
            } else {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.pop();
        }

        T peek() {
            if (!out.isEmpty()) {
                return out.peek();
            } else {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.peek();
        }
    }
}