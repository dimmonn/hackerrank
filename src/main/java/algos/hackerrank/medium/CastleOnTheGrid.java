package algos.hackerrank.medium;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class CastleOnTheGrid {

  static class Node {

    private int x;
    private int y;
    private Set<Node> adjustment = new HashSet<>();

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Node)) {
        return false;
      }
      Node node = (Node) o;
      return x == node.x &&
          y == node.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }

    @Override
    public String toString() {
      return "Node{" +
          "x=" + x +
          ", y=" + y +
          '}';
    }

    // Complete the minimumMoves function below.
    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {

      Set<Node> cache = new HashSet<>();
      for (int i = 0; i < grid.length; i++) {
        char[] chars = grid[i].toCharArray();

        for (int j = 0; j < chars.length; j++) {
          if (chars[j] == 'X') {
            continue;
          }
          Node node = new Node(i, j);
          char[] to = Arrays.copyOfRange(chars, j, chars.length);
          char[] from = Arrays.copyOfRange(chars, 0, j);
          int hl = new String(to).indexOf('X');
          int hf = new String(from).lastIndexOf('X');
          int i1 = (hf == -1) ? 0 : hf + 1;
          int i2 = (hl == -1) ? chars.length : hl + j;
          for (int k = i1; k < i2; k++) {
            addAdjustment(k, node, i);

          }

          for (int k = i; k >= 0; k--) {
            if (grid[k].charAt(j) == 'X') {
              break;
            }
            addAdjustment(j, node, k);
          }
          for (int k = i; k <= chars.length - 1; k++) {
            if (grid[k].charAt(j) == 'X') {
              break;
            }
            addAdjustment(j, node, k);
          }
          cache.add(node);
        }

      }

      Node source = getNodeByCoordinates(startX, startY, cache);
      Node destination = getNodeByCoordinates(goalX, goalY, cache);

      return getPathLengthIfAny(source, destination, cache);


    }

    private static void addAdjustment(int j, Node node, int k) {
      if (!node.equals(new Node(k, j))) {
        node.adjustment.add(new Node(k, j));
      }
    }

    private static int getPathLengthIfAny(Node source, Node destination, Set<Node> cache) {

      for (Node node : source.adjustment) {
        if (destination.adjustment.contains(node)) {
          return 2;
        }
      }

      LinkedList<Node> queue = new LinkedList<>();
      Map<Node, Integer> map = new HashMap<>();

      map.put(source, 0);
      queue.add(source);
      while (!queue.isEmpty()) {
        Node poll = queue.poll();
        buildLengthPerNeighbour(destination, cache, queue, map, poll);
      }

      return map.get(destination);
    }

    private static void buildLengthPerNeighbour(Node destination, Set<Node> cache,
        LinkedList<Node> queue, Map<Node, Integer> map, Node poll) {
      for (Node node : poll.adjustment) {
        if (map.get(node) == null) {
          node = getNodeByCoordinates(node.x, node.y, cache);
          map.put(node, map.get(poll) + 1);
          queue.add(node);
          if (node.equals(destination)) {
            break;
          }
        }
      }
    }

    private static Node getNodeByCoordinates(int startX, int startY, Set<Node> cache) {

      for (Node node : cache) {
        if (node.x == startX && node.y == startY) {
          return node;
        }
      }
      return null;
    }


  }
}
