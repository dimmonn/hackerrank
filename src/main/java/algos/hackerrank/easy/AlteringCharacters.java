package algos.hackerrank.easy;

public class AlteringCharacters {

    static int alternatingCharacters(String s) {
        int result = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length-1; i++) {
            if (chars[i] == chars[i + 1]) {
                result++;
            }


        }
        return result;

    }

}
