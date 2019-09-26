package algos.hackerrank.linkedlist;

public class InsertAnodeAtAspecificPosition {

  static class SinglyLinkedListNode {

    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
      this.data = nodeData;
      this.next = null;
    }

    @Override
    public String toString() {
      return "SinglyLinkedListNode{" +
          "data=" + data +
          ", next=" + next +
          '}';
    }
  }

  static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head,
      int data,
      int position) {
    if (position == 0) {
      SinglyLinkedListNode _node = new SinglyLinkedListNode(data);
      _node.next = head;
      return _node;
    }
    head.next = insertNodeAtPosition(head.next, data, position - 1);
    return head;
  }

  public static void main(String[] args) {
    SinglyLinkedListNode node = new SinglyLinkedListNode(16);
    node.next = new SinglyLinkedListNode(13);
    node.next.next = new SinglyLinkedListNode(7);
    SinglyLinkedListNode singlyLinkedListNode = insertNodeAtPosition(node, 1, 2);
    System.out.println(singlyLinkedListNode);
  }

}
