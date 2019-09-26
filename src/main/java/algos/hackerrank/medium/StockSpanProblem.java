package algos.hackerrank.medium;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {
    public static long[] calculate1(long[] stocks) {
        long[] results = new long[stocks.length];
        Stack<Integer> integers = new Stack<>();
        results[0] = 1;
        integers.push(0);
        for (int i = 1; i < stocks.length; i++) {
            long stock = stocks[i];
            if (integers.isEmpty()) {
                integers.push(i);

            } else {
                if (stock < stocks[integers.peek()]) {
                    integers.push(i);
                } else {
                    while (!integers.isEmpty() && stocks[integers.peek()] <= stock) {
                        integers.pop();
                    }

                }

            }
            results[i] = (!integers.isEmpty() && integers.peek() == i ? i + 1 : i + 1) - (integers.isEmpty() ? 0 : integers.peek());
        }

        return results;

    }

    public static long[] calculate(long[] stocks) {
/** Base case: when array is empty **/
        if (stocks.length == 0) {
            return new long[]{0};
        }
        long[] result = new long[stocks.length];
/** To hold highest index of stack **/
        Stack<Integer> stack = new Stack<>();
/** Initial value for index 0, because span for 0th index is always 1 **/
        stack.push(0);
        result[0] = 1;
/** Iterate all stock from index 1 onward **/
        for (int i = 1; i < stocks.length; i++) {
/** Remove all index from stack whose stock value is lesser than current stock **/
            while (!stack.isEmpty() && stocks[stack.peek()] <= stocks[i]) {
                stack.pop();
            }
/** Case 1. When all stock value is smaller than current stock **/
            if (stack.isEmpty()) {
                result[i] = i + 1;
            } else {
/** Case 2. When there is at-least one previous stock who is higher than current stock **/
                result[i] = (i - stack.peek());
            }
/** Push current index to stack for further comparision **/
            stack.push(i);
        }
        return result;
    }


    public static void main(String[] args) {
        long[] stock = new long[]{100, 60, 70, 65, 80, 85, 45, 77, 56, 98, 200};
        long[] calculate = calculate(stock);
        Arrays.stream(calculate).forEach(System.out::print);
    }

}

//11214112191

//112145121911