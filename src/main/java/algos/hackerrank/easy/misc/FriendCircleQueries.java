package algos.hackerrank.easy.misc;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import org.springframework.util.StopWatch;

public class FriendCircleQueries {

  static Map<Integer, FriendsCircle> roots = new HashMap<>();
  static Map<Integer, Integer> cache = new HashMap<>();
  static int[] maxFriendsPerQuery;
  static int max = 0;

  static int[] maxCircle(int[][] queries) {

    Map<Integer, Integer> result = new HashMap<>();
    maxFriendsPerQuery = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
      int a = queries[i][0];
      int b = queries[i][1];
      union(result, a, b);
      maxFriendsPerQuery[i] = max;
    }
    return maxFriendsPerQuery;
  }

  private static void union(Map<Integer, Integer> result, int a, int b) {
    Integer rootFarFrom = cache.getOrDefault(a, a);
    Integer rootFarTo = cache.getOrDefault(b, b);
    int rootFrom = rootOf(result, rootFarFrom);
    int rootTo = rootOf(result, rootFarTo);
    cache.put(b, rootTo);
    cache.put(a, rootTo);
    if (rootFrom == rootTo) {
      return;
    }
    FriendsCircle friendRequester = new FriendsCircle();
    FriendsCircle friendAcceptor = new FriendsCircle();
    friendRequester.id = rootFrom;
    friendAcceptor.id = rootTo;
    result.put(rootFrom, rootTo);

    if (roots.get(friendRequester.id) != null || roots.get(friendAcceptor.id) != null) {
      friendRequester = roots.getOrDefault(friendRequester.id, friendRequester);
      friendAcceptor = roots.getOrDefault(friendAcceptor.id, friendAcceptor);
      roots.remove(friendAcceptor.id);
      friendAcceptor.max += friendRequester.max;
      friendAcceptor.prev.add(friendRequester);
      roots.remove(friendRequester.id);
      roots.put(friendAcceptor.id, friendAcceptor);
      updateMaxFriends(friendAcceptor);

    } else {
      friendRequester.max = 1;
      friendAcceptor.max = 2;
      friendAcceptor.prev.add(friendRequester);
      roots.put(friendAcceptor.id, friendAcceptor);
      updateMaxFriends(friendAcceptor);
    }
  }

  private static void updateMaxFriends(FriendsCircle friendAcceptor) {
    if (max < friendAcceptor.max) {
      max = friendAcceptor.max;
    }
  }


  private static int rootOf(Map<Integer, Integer> result, int a) {
    Integer cachedRootFar = result.getOrDefault(a, a);
    if (cachedRootFar == a) {
      return cachedRootFar;
    }
    Integer cachedRootCloser = cache.getOrDefault(cachedRootFar, cachedRootFar);
    int topRoot = rootOf(result, cachedRootCloser);
    if (cachedRootFar != topRoot) {
      cache.put(cachedRootFar, topRoot);
    }
    return topRoot;
  }

  static class FriendsCircle {

    Set<FriendsCircle> prev = new HashSet<>();
    int id;
    int max = 1;

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      FriendsCircle f = (FriendsCircle) o;
      return id == f.id;
    }

    @Override
    public int hashCode() {
      return id;
    }
  }


  public static void main(String[] args) throws IOException {
    /*   int[][] s = new int[][]{{6, 4}, {5, 9}, {8, 5}, {4, 1}, {1, 5}, {7, 2}, {4, 2}, {7, 6}};*/
    //System.out.println(maxCircle(r));
    int[][] s = Files.readAllLines(Paths.get("/Users/dpolishc/Downloads/test.out"))
        .stream()
        .map(e -> Stream.of(e.split(" ")).mapToInt(Integer::parseInt).toArray())
        .toArray(int[][]::new);
    StopWatch watch = new StopWatch();
    watch.start();
    System.out.println(maxCircle(s));
    watch.stop();

    System.out.println("Time Elapsed: " + watch.prettyPrint()); // Prints: Time Elapsed: 2501
  }
}
