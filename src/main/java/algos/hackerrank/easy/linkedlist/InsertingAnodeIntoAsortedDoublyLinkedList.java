package algos.hackerrank.easy.linkedlist;

import java.util.Objects;

public class InsertingAnodeIntoAsortedDoublyLinkedList {

  static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {

    if (head != null && head.data > data) {
      DoublyLinkedListNode doublyLinkedListNode = new DoublyLinkedListNode(data);
      doublyLinkedListNode.next = head;
      head.prev = doublyLinkedListNode;
      return doublyLinkedListNode;
    } else if (Objects.requireNonNull(head).next == null) {
      DoublyLinkedListNode doublyLinkedListNode = new DoublyLinkedListNode(data);
      head.next = doublyLinkedListNode;
      doublyLinkedListNode.prev = head;
      return head;
    }

    DoublyLinkedListNode inserted = sortedInsert(head.next, data);
    inserted.prev = head;
    head.next = inserted;
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
}
