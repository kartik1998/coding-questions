package Divide_And_Conquer;

// For a given number n, form a list and insert the following pattern into the list at the same position sequentially.
//{floor(n/2) , n%2 , floor(n/2) }
//Until every element in the list is either 1 or 0. Now, calculate number of 1s in from l to r (1-indexed).
//
//EXPLAINATION: Start from n. Then make a list with the following elements.i.e. {floor(n/2) , n%2 , floor(n/2) }.
// Now this list has three elements. Now further break down each of those 3 elements considering the new n to be floor(n/2)
// , n%2 and floor(n/2) respectively for those three elements respectively INPLACE.
// And this process will go on until the n reduces down to 1 or 0.
// So it will basically form a tree with 3 branches coming out of every node at every level
// starting from 1 node (n) at the root.
import java.util.ArrayList;
import java.util.Scanner;

class Node {

  Node left, right, down;
  int data;

  Node(int data) {
    this.data = data;
    this.left = this.right = this.down = null;
  }
}

public class Simple_Enough {

  static ArrayList<Integer> a = new ArrayList<>();

  public static Node helper(int n, Node root) {
    if (n == 1 || n == 0) {
      return new Node(n);
    }
    root = new Node(n);
    root.left = helper(n / 2, root);
    root.down = helper(n % 2, root);
    root.right = helper(n / 2, root);
    return root;
  }

  public static void print(Node root) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      a.add(root.data);
      return;
    }
    print(root.left);
    print(root.down);
    print(root.right);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int l = sc.nextInt();
    int r = sc.nextInt();
    Node root = helper(n, null);
    print(root);
    int count = 0;
    for (int i = l - 1; i <= r - 1; i++) {
      if (a.get(i) == 1) {
        count++;
      }
    }
    System.out.println(count);
    for (int i : a) {
      System.out.print(i + " ");
    }
  }
}
