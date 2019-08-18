package algos.hackerrank.easy.tree;

public class HeightOfAbinaryTree {


  static class Node {

    Node left;
    Node right;
    int data;

    Node(int data) {
      this.data = data;
      left = null;
      right = null;
    }

  }


  public static int height(Node root) {

    if (root == null) {
      return -1;
    }
    return 1 + Math.max(height(root.left), height(root.right));
  }


}

