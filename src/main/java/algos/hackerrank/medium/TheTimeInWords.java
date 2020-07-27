package algos.hackerrank.medium;

import java.util.HashMap;
import java.util.Map;

public class TheTimeInWords {

  static final Map<Integer, String> numbers =
      new HashMap<Integer, String>() {
        {
          put(0, "zero");
          put(1, "one");
          put(2, "two");
          put(3, "three");
          put(4, "four");
          put(5, "five");
          put(6, "six");
          put(7, "seven");
          put(8, "eight");
          put(9, "nine");
          put(10, "ten");
          put(11, "eleven");
          put(12, "twelve");
          put(13, "thirteen");
          put(14, "fourteen");
          put(15, "fifteen");
          put(16, "sixteen");
          put(17, "seventeen");
          put(18, "eighteen");
          put(19, "nineteen");
          put(20, "twenty");
          put(21, "twenty one");
          put(22, "twenty two");
          put(23, "twenty three");
          put(24, "twenty four");
          put(25, "twenty five");
          put(26, "twenty six");
          put(27, "twenty seven");
          put(28, "twenty eight");
          put(29, "twenty nine");
        }
      };

  static String timeInWords(int h, int m) {
    String result = "";
    if (m == 00) {
      result = numbers.get(h) + " o' clock";
    } else if (m == 15) {
      result = "quarter past " + numbers.get(h);
    } else if (m == 30) {
      result = "half past " + numbers.get(h);
    } else if (m == 45) {
      result = "quarter to " + numbers.get(h + 1);
    } else if (m == 1) {
      result = numbers.get(m) + " minute past " + numbers.get(h);
    } else if (60 - m > 30 && m > 0) {
      result = numbers.get(m) + " minutes past " + numbers.get(h);
    } else if (60 - m < 30) {
      result = numbers.get(60 - m) + " minutes to " + numbers.get(h + 1);
    }
    return result;
  }
}
