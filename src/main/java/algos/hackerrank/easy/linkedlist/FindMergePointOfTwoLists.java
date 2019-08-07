package algos.hackerrank.easy.linkedlist;

public class FindMergePointOfTwoLists {

  static class SinglyLinkedListNode {

    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
      this.data = nodeData;
      this.next = null;
    }
  }

  static class SinglyLinkedList {

    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
      this.head = null;
      this.tail = null;
    }

    public void insertNode(int nodeData) {
      SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

      if (this.head == null) {
        this.head = node;
      } else {
        this.tail.next = node;
      }

      this.tail = node;
    }
  }

  static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    SinglyLinkedListNode currentA = head1;
    SinglyLinkedListNode currentB = head2;

    while (currentA != currentB) {
      if (currentA.next == null) {
        currentA = head2;
      } else {
        currentA = currentA.next;
      }
      if (currentB.next == null) {
        currentB = head1;
      } else {
        currentB = currentB.next;
      }
    }
    return currentB.data;

  }

}
