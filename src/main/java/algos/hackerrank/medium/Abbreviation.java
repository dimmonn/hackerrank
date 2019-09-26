package algos.hackerrank.medium;

import java.io.IOException;

public class Abbreviation {

  static String abbreviation1(String a, String b) {
    char[] a1 = a.toCharArray();
    char[] b1 = b.toCharArray();

    for (int i = b1.length - 1; i >= 0; i--) {

      for (int j = a1.length - 1; j >= 0; j--) {
        char c = b1[i];
        char c1 = a1[j];
        if (c1==c||Character.toUpperCase(c1)==c||Character.isUpperCase(c1)) {
          if (i>0) {
            i--;
            continue;
          }
          else return "NO";

        }
      else if (Character.isUpperCase(c1)&&c1!=c){
        return "NO";
        }
      else i--;
      }


    }

    //abcAd
    //ABcAd
    return "YES";
  }


   /* static String abbreviation(String a, String b) {
        char[] chars = a.toCharArray();
        char[] upperCase = b.toCharArray();

        Map<Character, Integer> characterMapA = new HashMap<>();

        for (char aChar : chars) {
            characterMapA.put(aChar, characterMapA.getOrDefault(aChar, 0) + 1);
        }

        Map<Character, Integer> characterMapB = new HashMap<>();

        for (char aChar : upperCase) {
            characterMapB.put(aChar, characterMapB.getOrDefault(aChar, 0) + 1);
        }
        Map<Character, Integer> characterMapAll = new HashMap<>();

        for (char aChar : upperCase) {
            characterMapAll.put(aChar, characterMapAll.getOrDefault(aChar, 0) + 1);
        }


        for (int k = 0; k < upperCase.length; k++) {
            char c = upperCase[k];
            Map<Character, Integer> characterDelta = new HashMap<>();
            char upper = Character.toUpperCase(c);
            char lower = Character.toLowerCase(c);
            int indexAup = a.indexOf(upper);
            int indexADown = a.indexOf(lower);

            if (indexAup < 0 && indexADown < 0) {
                return "NO";
            } else {
                int i1 = 0;


                int sticky = b.indexOf(c);
                int sTmpA = 1;
                for (int i = k; i < b.length() - 1; i++) {

                    if (b.charAt(i) == b.charAt(i + 1)) {
                        sTmpA++;
                    } else {
                        characterDelta.put(c, sTmpA);
                        break;
                    }

                }
                if (characterMapA.get(c) != null && characterDelta.get(c) != null && characterDelta.get(c) < 0) {
                    return "NO";
                }
                if (characterMapA.get(c) != null && characterDelta.get(c) != null && characterDelta.get(c) == 0) {
                    i1 = indexAup + 1;
                    //    System.out.println("test2");
                } else if (characterMapA.get(c) != null && characterDelta.get(c) != null && characterDelta.get(c) > 0) {

                    int tmpidx2 = indexAup;
                    int tmp = characterDelta.get(c);
                    for (int i = 0; i < characterDelta.get(c); i++) {
                        if (tmp != 0) {
                            tmpidx2 = a.lastIndexOf(Character.toLowerCase(c), tmpidx2);
                            if (tmpidx2 < 0) {
                                tmpidx2 = a.lastIndexOf(c, indexAup);
                            }
                            tmp--;
                            tmpidx2--;

                        }
                        if (tmp == 1)
                            i1 = tmpidx2 + 2 + characterDelta.get(c);
                    }
                    //     System.out.println("test1");
                } else if (indexAup >= 0 && indexAup < indexADown && indexADown >= 0) {
                    i1 = indexAup + 1;
                } else if (indexAup >= 0 && indexAup > indexADown && indexADown >= 0 && characterDelta.get(c) > 0) {
                    i1 = indexADown + 1;
                    characterDelta.put(c, characterDelta.get(c) - 1);
                } else if (indexAup >= 0 && indexADown < 0) {
                    i1 = indexAup + 1;
                } else if (indexAup < 0 && indexADown >= 0 && characterDelta.get(c) != null && characterDelta.get(c) > 0) {
                    i1 = indexADown + 1;
                    characterDelta.put(c, characterDelta.get(c) - 1);
                } else {
                    System.out.println();
                }
                if (characterMapA.get(c) != null && characterDelta.get(c) != null && characterMapA.get(c) > characterMapAll.get(c)) {
                    return "NO";
                }

                for (int j = 0; j < i1; j++) {
                    characterMapA.put(chars[j], characterMapA.get(chars[j]) - 1);
                    characterMapB.put(chars[j], characterMapB.get(c) - 1);

                    if (Character.isUpperCase(chars[j]) && Character.toUpperCase(chars[i1 - 1]) != c && (i1 != 1) || (Character.isUpperCase(chars[j]) && j < i1 - 1)) {
                        return "NO";
                    }


                }

                k = k + characterDelta.get(c) - 1;

            }

        }
        for (char aChar : chars) {
            if (Character.isUpperCase(aChar) && aChar != b.charAt(b.length() - 1)) {
                return "NO";
            }
        }
        return "YES";
    }*/

  public static void main(String[] args) throws IOException {
  //  System.out.println(abbreviation1("beFgH", "EFH"));
    /*   List<String> list = Files.readAllLines(Path.of("/Users/dpolishc/Downloads/test.log")).stream().collect(Collectors.toList());*/
//JHMWY
//HUVPW

    /*    for (int i = 0; i < list.size(); i++) {
            System.out.println(abbreviation1(list.get(i), list.get(i + 1)));
            i = i + 1;

        }*/

    //beFgH
    //EFH

    //daBcd
    //ABC
    // System.out.println(abbreviation("daBcd", "ABC"));
    //AbCdE
    //AFE

    // System.out.println(abbreviation("AbCdE", "AFE"));
    //System.out.println("afsdfasrfr".lastIndexOf('f', 6));
    //daBcd
    //ABC
    //AbCdE
    //AFE
    //beFgH
    //EFH
    //daBcd
    //ABC
    //KXzQ
    //K

    //AbCdE
    //AFE

    System.out.println(abbreviation1("AbCdE","AFE"));
  }
}


