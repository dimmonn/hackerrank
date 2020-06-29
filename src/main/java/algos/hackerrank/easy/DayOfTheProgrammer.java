package algos.hackerrank.easy;

public class DayOfTheProgrammer {
  static String dayOfProgrammer(int year) {
    String result = "";
    if (year == 1918) {
      result = "26.09.1918";
    } else if ((year < 1918 && year % 4 == 0)
        || (year > 1918 && year % 400 == 0)
        || year > 1918 && year % 4 == 0 && year % 100 != 0) {
      result = "12.10." + "" + year;
    } else {
      result = "13.10." + "" + year;
    }
    return result;
  }
}
