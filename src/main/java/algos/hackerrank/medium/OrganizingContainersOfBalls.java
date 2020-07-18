package algos.hackerrank.medium;

import java.util.*;

public class OrganizingContainersOfBalls {
  static String organizingContainers(int[][] container) {
    Map<Integer, Integer> type = new HashMap<>();
    Map<Integer, Integer> containers = new HashMap<>();
    for (int i = 0; i < container.length; i++) {
      int[] ints = container[i];
      containers.put(i, Arrays.stream(ints).sum());
    }
    for (int i = 0; i < container.length; i++) {
      int sum = 0;
      for (int[] ints : container) {
        sum += ints[i];
      }
      type.put(i, sum);
    }
    List<Integer> balls = new ArrayList<>(containers.values());
    List<Integer> types = new ArrayList<>(type.values());
    Collections.sort(balls);
    Collections.sort(types);
    return balls.equals(types) ? "Possible" : "Impossible";
  }
}
