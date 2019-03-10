package algos.hackerrank.advansed;

public class TwoComplements {
    static long twosCompliment(long a, long b) {
        long ones = 0;
        StringBuilder tmp = null;
        for (long i = a; i <= b; i++) {
            if (i < 0) {
                if (tmp == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String[] binaryString = Long.toBinaryString(Math.abs(i)).split("");

                    int lengthOfUnsignedString = binaryString.length - 1;
                    for (int k = 31; k >= 0; k--) {

                        if (lengthOfUnsignedString >= 0) {
                            stringBuilder.append(Byte.valueOf(binaryString[lengthOfUnsignedString]) == (byte) 0 ? (byte) 1 : (byte) 0);
                            lengthOfUnsignedString--;
                        } else {

                            stringBuilder.append(1);
                        }
                    }
                    stringBuilder.reverse();
                    tmp = stringBuilder;

                } else {
                    tmp = new StringBuilder(Long.toBinaryString(Long.parseLong(tmp.toString(), 2) + 1));
                    ones += tmp.toString().replace("0", "").length();
                    continue;
                }
                long twoComplement = Long.parseLong(tmp.toString(), 2);
                long result = twoComplement + 1;
                String binaryFinal = Long.toBinaryString(result);
                int one = binaryFinal.replace("0", "").length();
                ones += one;
            } else {
                ones += Long.toBinaryString(Math.abs(i)).replace("0", "").length();
            }
        }

        return ones;
    }
}
