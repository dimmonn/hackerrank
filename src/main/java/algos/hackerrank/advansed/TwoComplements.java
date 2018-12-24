package algos.hackerrank.advansed;

public class TwoComplements {
    static long twosCompliment(long a, long b) {
        long ones = 0;
        for (long i = a; i <= b; i++) {
            if (i < 0) {
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
                long twoComplement = Long.parseLong(stringBuilder.toString(), 2);
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

    public static void main(String[] args) {
        //System.out.println(Long.toBinaryString(Math.abs(-Long.MAX_VALUE-1)));
        System.out.println(twosCompliment(-2, 0));
        System.out.println(Integer.toBinaryString(-2));
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(-0));


    }
}
