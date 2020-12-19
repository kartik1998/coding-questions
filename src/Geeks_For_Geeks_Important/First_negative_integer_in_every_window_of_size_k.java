package Geeks_For_Geeks_Important;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class First_negative_integer_in_every_window_of_size_k {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int A[] = new int[n];
      for (int i = 0; i < n; i++) {
        A[i] = sc.nextInt();
      }
      Queue<Integer> q = new LinkedList<>();
      int k = sc.nextInt();
      for (int i = 0; i < k; i++) {
        if (A[i] < 0) {
          q.add(i);
        }
      }
      for (int i = k; i < A.length; i++) {
        if (!q.isEmpty()) {
          System.out.print(A[q.peek()] + " ");
        } else {
          System.out.print("0 ");
        }
        while (!q.isEmpty() && i - q.peek() >= k) {
          q.remove();
        }
        if (A[i] < 0) {
          q.add(i);
        }
      }
      while (!q.isEmpty() && n - 1 - q.peek() >= k) {
        q.remove();
      }
      if (!q.isEmpty()) {
        System.out.println(A[q.peek()]);
      } else {
        System.out.println(0);
      }
    }
  }
}
