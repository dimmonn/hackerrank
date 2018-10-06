package algos.hackerrank.warmup;

public class CountingValleys {
    static int countingValleys(int n, String s) {
        int level = 0;
        int valleys = 0;
        boolean isUpDirection = false;
        char[] in = s.toCharArray();
        for (char anIn : in) {
            if (anIn == 'U') {
                level++;
                isUpDirection = true;
            } else if (anIn == 'D') {
                level--;
                isUpDirection = false;
            }

            if (level == -1 && !isUpDirection) {
                valleys++;

            }
        }
        return valleys;
    }

}
