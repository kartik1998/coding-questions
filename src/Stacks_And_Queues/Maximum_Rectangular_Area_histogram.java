package Stacks_And_Queues;

import java.util.Scanner;
import java.util.Stack;

public class Maximum_Rectangular_Area_histogram {

  public static int[] prevSmaller(int A[]) {
    int prev[] = new int[A.length];
    Stack<Integer> s = new Stack<>();
    for (int i = 0; i < A.length; i++) {
      if (s.isEmpty()) {
        prev[i] = -1;
      } else {
        if (A[s.peek()] < A[i]) {
          prev[i] = s.peek();
        } else {
          while (!s.isEmpty() && A[s.peek()] >= A[i]) {
            s.pop();
          }
          if (s.isEmpty()) {
            prev[i] = -1;
          } else {
            prev[i] = s.peek();
          }
        }
      }
      s.push(i);
    }
    return prev;
  }

  public static int[] nextSmaller(int A[]) {
    int next[] = new int[A.length];
    int n = A.length;
    Stack<Integer> s = new Stack<>();
    for (int i = A.length - 1; i >= 0; i--) {
      if (s.isEmpty()) {
        next[i] = n;
      } else {
        if (A[s.peek()] < A[i]) {
          next[i] = s.peek();
        } else {
          while (!s.isEmpty() && A[s.peek()] >= A[i]) {
            s.pop();
          }
          if (s.isEmpty()) {
            next[i] = n;
          } else {
            next[i] = s.peek();
          }
        }
      }
      s.push(i);
    }
    return next;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int A[] = new int[n];
      for (int i = 0; i < n; i++) {
        A[i] = sc.nextInt();
      }
      int prev[] = prevSmaller(A);
      int next[] = nextSmaller(A);
      int max = 0;
      for (int i = 0; i < n; i++) {
        max = Math.max(max, A[i] * (next[i] - prev[i] - 1));
      }
      System.out.println(max);
    }
  }
}
