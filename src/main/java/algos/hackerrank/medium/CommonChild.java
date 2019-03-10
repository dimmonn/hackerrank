package algos.hackerrank.medium;

public class CommonChild {
    static Integer [][] arr = new Integer[5001][5001];
    static int commonChild(String s1, String s2) {
        return lcs(s1, s2, s1.length(), s2.length());
    }

    private static int lcs(String s1, String s2, int n1, int n2) {
        if (arr[n1][n2]!=null){
            return arr[n1][n2];
        }
        int result = 0;
        if (n1 == 0 || n2 == 0) {
            return 0;
        }
        if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1)) {
            result = 1+lcs(s1, s2, n1 - 1, n2 - 1);
        } else if (s1.charAt(n1 - 1) != s2.charAt(n2 - 1)) {
            int tmp1 = lcs(s1, s2, n1 - 1, n2);
            int tmp2 = lcs(s1, s2, n1, n2 - 1);
            result = tmp1 > tmp2 ? tmp1 : tmp2;

        }
        arr[n1][n2]=result;
        return result;
    }
}
