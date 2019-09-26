package algos.hackerrank.easy;

public class BinaryGap {
    public static int solution(int N) {
        int result = 0;
        String s = Integer.toBinaryString(N);
        int tmp = 0;

        while (tmp < s.length()) {

            int i = s.indexOf('0');

            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    result = result < j - i ? j - i : result;
                    tmp=j;
                }

            }
        }

        return result;

    }

    public static void main(String[] args) {

        System.out.println(Integer.toBinaryString(100));
        System.out.println(solution(100));
    }
}
