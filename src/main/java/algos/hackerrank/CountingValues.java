package algos.hackerrank;

public class CountingValues {
    static int countingValleys(int n, String s) {
        int level = 0;
        int valleys = 0;
        boolean isUpDirection = false;
        char[] in = s.toCharArray();
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 'U') {
                level++;
                isUpDirection = true;
            } else if (in[i] == 'D') {
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
