package algos.hackerrank.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class ReverseAoublyLinkedList {


  static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
    DoublyLinkedListNode tmp = head.next;

    head.next = head.prev;
    head.prev = tmp;
    if (tmp == null) {
      return head;
    } else {
      head = reverse(tmp);
    }
    return head;
  }


  static class DoublyLinkedListNode {

    public int data;
    public DoublyLinkedListNode next;
    public DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int nodeData) {
      this.data = nodeData;
      this.next = null;
      this.prev = null;
    }
  }

  static class DoublyLinkedList {

    public DoublyLinkedListNode head;
    public DoublyLinkedListNode tail;

    public DoublyLinkedList() {
      this.head = null;
      this.tail = null;
    }

    public void insertNode(int nodeData) {
      DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

      if (this.head == null) {
        this.head = node;
      } else {
        this.tail.next = node;
        node.prev = this.tail;
      }
      this.tail = node;
    }
  }

}
