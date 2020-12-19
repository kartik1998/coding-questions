package Stacks_And_Queues;

import java.util.Scanner;
import java.util.Stack;

public class Smallest_number_on_left {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      Stack<Integer> s = new Stack<>();
      int n = sc.nextInt();
      int A[] = new int[n];
      int ans[] = new int[n];
      for (int i = 0; i < n; i++) {
        A[i] = sc.nextInt();
        if (s.isEmpty()) {
          ans[i] = -1;
        } else {
          if (A[i] > A[s.peek()]) {
            ans[i] = s.peek();
          } else {
            while (!s.isEmpty() && A[i] <= A[s.peek()]) {
              s.pop();
            }
            if (s.isEmpty()) {
              ans[i] = -1;
            } else {
              ans[i] = s.peek();
            }
          }
        }
        s.push(i);
      }
      for (int i = 0; i < ans.length; i++) {
        if (ans[i] == -1) {
          System.out.print("-1 ");
        } else {
          System.out.print(A[ans[i]] + " ");
        }
      }
      System.out.println();
    }
  }
}
