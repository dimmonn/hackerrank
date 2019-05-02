package algos.hackerrank.medium;

import java.util.Collections;
import java.util.Stack;

public class LargestRectangle {
    static Stack<Integer> rectangles = new Stack<>();

    static long largestRectangle1(int[] h) {
        for (int i = 0; i < h.length; i++) {
            int left = i - 1;
            int length = 1;
            int tmpIndex = h[i];
            for (int j = left; j >= 0; j--) {
                int i1 = h[j];
                if (tmpIndex <= i1) {
                    length++;
                } else {
                    break;
                }
            }
            int right = i + 1;
            for (int j = right; j < h.length; j++) {
                int i1 = h[j];
                if (tmpIndex <= i1) {
                    length++;
                } else {
                    break;
                }
            }

            int max = Math.max(rectangles.isEmpty() ? 0 : rectangles.pop(), tmpIndex * length);

            rectangles.push(max);
        }
        return rectangles.pop();
    }

    static long largestRectangle(int[] h) {
        runover(h, 0);
        return Collections.max(rectangles);
    }

    private static void runover(int[] i1, int index) {
        if (index >= i1.length) {
            return;
        }
        int tmpIndex = i1[index];
        int length = 1;
        int left = index - 1;
        int right = index + 1;
        if (left >= 0 && tmpIndex <= i1[left]) {
            while (left >= 0) {
                if (tmpIndex <= i1[left--]) {
                    length++;
                } else {
                    break;
                }
            }
        }
        if (right < i1.length && tmpIndex <= i1[right]) {
            while (right < i1.length) {
                if (tmpIndex <= i1[right++]) {
                    length++;
                } else {
                    break;
                }
            }
        }

        rectangles.add(tmpIndex * length);
        runover(i1, ++index);
    }
}
