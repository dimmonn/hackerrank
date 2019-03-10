package algos.hackerrank.codility;

import java.util.Arrays;

public class Solution {
    public static int solution1(int[] A) {
        Arrays.sort(A);
        int smallest = 1;
        for (int i = 0; i < A.length; i++) {
            if (smallest < A[i]) {
                return smallest;
            } else if (A[i] > 0) {
                smallest = A[i] + 1;
            }
        }
        return A[A.length - 1] > 0 ? A[A.length - 1] + 1 : 1;
    }

    public static int solution4(String s) {

        int l = s.length();

       int counter=0;

        for (int i = 0; i < l; i++) {
            if (i+1==s.length()-1){

            }
            if (s.charAt(i) > s.charAt(i + 1)) {
               counter++;
            }
        }

     return  counter;
    }


}



