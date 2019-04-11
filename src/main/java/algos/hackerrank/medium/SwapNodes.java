package algos.hackerrank.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class SwapNodes {
    public static class Tree {
        private int data;
        private Tree left;
        private Tree right;

        public Tree(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Tree getLeft() {
            return left;
        }

        public void setLeft(Tree left) {
            this.left = left;
        }

        public Tree getRight() {
            return right;
        }

        public void setRight(Tree right) {
            this.right = right;
        }

    }



    static Tree createBinaryTree(int[][] indexes) {
        Tree root = new Tree(1);
        Queue<Tree> nextNodes = new LinkedList<>();
        Tree curr;
        nextNodes.add(root);
        Tree leftNode, rightNode;
        int[] nodes ;
        int totalNodes = 1;
        for (int[] index : indexes) {
            curr = nextNodes.remove();
            nodes = index;
            if (nodes[0] != -1) {
                // Add it to the left node of curr...
                leftNode = new Tree(nodes[0]);
                totalNodes++;
                nextNodes.add(leftNode);
                curr.setLeft(leftNode);
            }
            if (nodes[1] != -1) {
                rightNode = new Tree(nodes[1]);
                totalNodes++;
                nextNodes.add(rightNode);
                curr.setRight(rightNode);
            }
        }
        root.setData(totalNodes);
        return root;
    }

    static HashMap<Integer, ArrayList<Tree>> generateLevelNodes(Tree root) {
        Queue<Tree> nextNodes = new LinkedList<>();
        Tree curr;
        nextNodes.add(root);
        int count = 1,level=1,updateCount = 0;
        ArrayList<Tree> nodes = new ArrayList<>();
        HashMap<Integer, ArrayList<Tree>> levelNodes = new HashMap<>();
        while(!nextNodes.isEmpty()) {
            curr = nextNodes.remove();
            nodes.add(curr);
            if(curr.getLeft() != null) {
                updateCount ++;
                nextNodes.add(curr.getLeft());
            }
            if(curr.getRight()!= null) {
                updateCount ++;
                nextNodes.add(curr.getRight());
            }
            count--;
            if(count == 0) {
                levelNodes.put(level, nodes);
                count = updateCount;
                updateCount = 0;
                nodes = new ArrayList<>();
                level++;
            }
        }
        return levelNodes;
    }
    static int var = 0;
    static int[] inOrderArray ;
    static void inOrderTraversal(Tree root) {
        if(root == null) {
            return;
        }
        inOrderTraversal(root.getLeft());
        inOrderArray[var++] = root.getData();
        inOrderTraversal(root.getRight());
    }

    static void modifyNodesByDepth(ArrayList<Tree> currLevelNodes) {
        Tree temp;
        for(Tree curr : currLevelNodes) {
            if(curr.getLeft()!= null && curr.getRight()!= null) {
                temp = curr.getLeft();
                curr.setLeft(curr.getRight());
                curr.setRight(temp);
            }else {
                if(curr.getLeft()!= null) {
                    curr.setRight(curr.getLeft());
                    curr.setLeft(null);
                }
                else if(curr.getRight()!= null) {
                    curr.setLeft(curr.getRight());
                    curr.setRight(null);
                }
            }


        }
    }

    static int[][] swapNodes(int[][] indexes, int[] queries) {
        Tree root = createBinaryTree(indexes);
        int[][] levelTraversal = new int[queries.length][root.getData()];
        root.setData(1);
        HashMap<Integer, ArrayList<Tree>> levelNodes = generateLevelNodes(root);
        int maxDepth = levelNodes.size()-1;
        int multiplyK = 1,depth,k;
        inOrderArray = new int[levelTraversal[0].length];
        for(int i=0; i<queries.length;i++) {
            k = queries[i];
            depth = k*multiplyK++;
            while(depth<= maxDepth) {
                modifyNodesByDepth(levelNodes.get(depth));
                depth = k*multiplyK++;
            }
            multiplyK =1;
            inOrderTraversal(root);
            var = 0;
            levelTraversal[i] = inOrderArray;
            inOrderArray = new int[levelTraversal[0].length];
        }
        return levelTraversal;
    }
}
