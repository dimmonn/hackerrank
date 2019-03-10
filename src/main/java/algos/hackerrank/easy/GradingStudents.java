package algos.hackerrank.easy;

public class GradingStudents {
    static int[] gradingStudents(int[] grades) {
        int[] result = new int[grades.length];
        for (int i = 0; i < grades.length; i++) {
            if (5 - grades[i] % 5 < 3 && grades[i] >= 38) {
                result[i] = grades[i] - grades[i] % 5 + 5;
            } else {
                result[i] = grades[i];
            }

        }
        return result;
    }
}
