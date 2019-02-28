package algos.hackerrank.medium;

import java.util.*;

public class FraudulentActivityNotifications {

    public static void insertToSortedList(List<Integer> array, Integer e) {
        int left, right, mid;


        left = 0;
        right = array.size();


        while (left < right) {
            mid = (left + right) / 2;
            int result = ((Comparator<Integer>) Comparator.naturalOrder()).compare(array.get(mid), e);


            if (result > 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        array.add(left, e);

    }

    static int activityNotifications(int[] expenditure, int d) {
        int result = 0;
        List<Integer> q = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < d; i++) {
            q.add(expenditure[i]);
            tmp.add(expenditure[i]);

        }
        Collections.sort(q);
        for (int i = d; i < expenditure.length - 1; i++) {
            double median_ = q.size() % 2 == 0 ? (double) (q.get(q.size() / 2) + q.get((q.size() / 2) - 1)) / 2
                    : q.get(q.size() / 2);
            if (expenditure[i] >= median_ * 2) {
                result++;
            }
            int i1 = Collections.binarySearch(q, tmp.get(0));
            q.remove(i1);
            tmp.remove(0);
            tmp.add(expenditure[i]);

            insertToSortedList(q, expenditure[i]);


        }
        return result;
    }
}
