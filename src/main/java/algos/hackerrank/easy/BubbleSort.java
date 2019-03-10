package algos.hackerrank.easy;

public class BubbleSort {
    static void countSwaps(int[] a) {
        int n = a.length;
        int swaps = 0;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    swap(j, j + 1, a);
                    swaps++;
                }
            }

        }
        System.out.println("Array is sorted in " + swaps + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length - 1]);

    }

    static void swap(int a, int b, int[] c) {
        int tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;

    }
}