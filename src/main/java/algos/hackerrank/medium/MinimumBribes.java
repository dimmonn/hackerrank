package algos.hackerrank.medium;



public class MinimumBribes {

    //wrong one
    static void minimumBribes(int[] q) {
        int result = 0;
        int delta = 0;
        for (int j = 0; j < q.length; j++) {
            if (q[j] != j + 1) {
                int biggerThenCurrent = q.length - q[j];
                int swaps = Math.abs(q[j] - j - 1);
                int abs = swaps - biggerThenCurrent;
                if (j == q.length - 1 && q[j] < j + 1 && abs < 3) {
                    result += swaps;
                } else if (q[j] < j + 1 && abs < 3 && q[j] > q[j + 1]) {
                    //goes right
                    delta++;
                    result += swaps;
                } else if (q[j] < j + 1 && abs < 3 && q[j] < q[j + 1]) {
                    //goes left

                    result += swaps;
                } else if (q[j] > j + 1 && swaps < 3) {
                    //goes right
                    result += swaps;
                } else {
                    System.out.println("Too chaotic");
                    return;
                }
            }


        }
        System.out.println(result / 2 + delta);
    }


    static void minimumBribes1(int[] q) {
        int count = 0;

        //always keep track of min three vlaues observed
        //Compare currently seeing value with this three values.
        int midOfThree = Integer.MAX_VALUE;
        int maxOfThree = Integer.MAX_VALUE;
        int minOfThree = Integer.MAX_VALUE;

        //iterating from left to right
        for (int i = q.length - 1; i >= 0; i--) {
            //person has no way to move more than two positions -> wrong
            if ((q[i] - i) > 3) {
                System.out.println("Too chaotic");
                return;
            } else {
                //means current value has passed at least 3 values -> wrong
                if (q[i] > maxOfThree) {
                    System.out.println("Too chaotic");
                    return;
                } else if (q[i] > midOfThree) { //means -> current value has bribed 2 ppl
                    count = count + 2;
                } else if (q[i] > minOfThree) { //means-> current value has bribed 1 person.
                    count = count + 1;
                }

                //Now adjust minThree values comparing, taking the current vlaue to account
                if (q[i] < minOfThree) {
                    maxOfThree = midOfThree;
                    midOfThree = minOfThree;
                    minOfThree = q[i];
                } else if (q[i] < midOfThree) {
                    maxOfThree = midOfThree;
                    midOfThree = q[i];
                } else if (q[i] < maxOfThree) {
                    maxOfThree = q[i];
                }
            }
        }
        System.out.println(count);

    }

}