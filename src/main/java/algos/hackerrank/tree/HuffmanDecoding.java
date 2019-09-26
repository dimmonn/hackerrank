package algos.hackerrank.tree;

import java.util.Stack;

public class HuffmanDecoding {


  static class Node {

    public int frequency;
    public char data;
    public Node left, right;
  }

  void decode(String s, Node root) {
    char[] chars = s.toCharArray();
    Stack<Character> characters = new Stack<>();
    for (int i = chars.length - 1; i >= 0; i--) {
      characters.push(chars[i]);
    }
    StringBuilder result = new StringBuilder();
    Node tmp = root;
    while (!characters.isEmpty()) {
      int i = Integer.parseInt(characters.pop().toString());
      tmp = i == 0 ? tmp.left : tmp.right;
      if (tmp.left == null && tmp.right == null) {
        result.append(tmp.data);
        tmp = root;
      }
    }
    System.out.println(result.toString());
  }

}