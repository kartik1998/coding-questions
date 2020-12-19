package Dynamic_Programming;

import java.util.Scanner;

public class Maximum_Sum_Subsequence_without_Adjacent {

  public static int helper(int A[], int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return A[n - 1];
    }
    if (n == 2) {
      return Math.max(A[n - 1], A[n - 2]);
    }
    return Math.max(A[n - 1] + helper(A, n - 2), helper(A, n - 1));
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
      System.out.println(helper(A, n));
    }
  }
}
