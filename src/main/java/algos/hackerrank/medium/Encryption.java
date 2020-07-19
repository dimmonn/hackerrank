package algos.hackerrank.medium;

public class Encryption {
  static String encryption(String s) {
    s = s.trim();
    int floor = (int) Math.floor(Math.sqrt(s.length()));
    int ceil = (int) Math.ceil(Math.sqrt(s.length()));
    floor = floor * ceil < s.length() ? ceil : floor;
    char[][] matrix = new char[floor][ceil];
    int index = 0;
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (index < s.length()) {
          matrix[i][j] = s.charAt(index);
          index++;
        }
      }
    }
    for (int i = 0; i < matrix[0].length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        if (matrix[j][i] != 0) {
          result.append(matrix[j][i]);
        }
      }
      result.append(" ");
    }
    return result.toString().substring(0, result.length() - 1);
  }
}
