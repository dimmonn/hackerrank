package algos.hackerrank.warmup;

public class JumpingOnTheClouds {
    static int jumpingOnClouds(int[] c) {
        int count = 0;
        for (int i = 0; i < c.length - 1; i++) {
            if (i < c.length - 2 && c[i + 2] == 0) {
                i++;

            }
            count++;
        }
        return count;
    }

}
