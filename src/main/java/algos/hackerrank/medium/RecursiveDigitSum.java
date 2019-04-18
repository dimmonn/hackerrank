package algos.hackerrank.medium;

public class RecursiveDigitSum {
    static int superDigit(String n, int k) {
        long sum = 0;
        for (int i = 0; i < n.length(); i++) {
            sum += Long.valueOf(Character.toString(n.charAt(i)));
        }
        sum *= k;

        long result = superSum(sum);
        return (int) result;
    }

    private static long superSum(long sum) {

        if (sum <= 9) {
            return sum;
        }

        String strinSum = String.valueOf(sum);
        long tmpResult = 0;
        for (int i = 0; i < strinSum.length(); i++) {
            tmpResult += Long.valueOf(Character.toString(strinSum.charAt(i)));

        }
        return superSum(tmpResult);
    }
}
