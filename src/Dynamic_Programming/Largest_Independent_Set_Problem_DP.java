package Dynamic_Programming;

import java.util.HashMap;

public class Largest_Independent_Set_Problem_DP {

  static class Node {

    int data;
    Node left, right;

    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  HashMap<Node, Integer> map = new HashMap<>();

  public int LISS(Node root) {
    return helper(root);
  }

  public int helper(Node root) {
    if (root == null) {
      return 0;
    }
    if (map.containsKey(root)) {
      return map.get(root);
    }
    int a = helper(root.left) + helper(root.right);
    int b = 1;
    if (root.left != null) {
      b += helper(root.left.left) + helper(root.left.right);
    }
    if (root.right != null) {
      b += helper(root.right.left) + helper(root.right.right);
    }
    map.put(root, Math.max(a, b));
    return Math.max(a, b);
  }
}
