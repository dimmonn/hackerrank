package algos.hackerrank.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class DetectCycle {

  class Node {

    int data;
    Node next;
  }

  boolean hasCycle(Node head) {
    if (head == null) {
      return false;
    }
    List<Node> objects = new ArrayList<>();
    objects.add(head);

    while (head.next != null) {
      Node x = head.next;
      for (Node object : objects) {

        if (object == x) {
          return true;
        }
      }
      objects.add(x);
      head = head.next;
    }
    return false;

  }

  public static void main(String[] args) {

  }
}
