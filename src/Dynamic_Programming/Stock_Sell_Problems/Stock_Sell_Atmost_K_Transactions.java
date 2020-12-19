package Dynamic_Programming.Stock_Sell_Problems;

import java.util.Scanner;

public class Stock_Sell_Atmost_K_Transactions {

  public static int helper(int A[], int in, int k, Integer dp[][]) {
    if (in >= A.length) {
      return 0;
    }
    if (k == 0) {
      return dp[k][in] = 0;
    }
    int min = A[in];
    int max = 0;
    if (dp[k][in] != null) {
      return dp[k][in];
    }
    for (int i = in + 1; i < A.length; i++) {
      max = Math.max(A[i] - min + helper(A, i + 1, k - 1, dp), max);
      min = Math.min(A[i], min);
    }
    return dp[k][in] = max;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int k = sc.nextInt();
      int n = sc.nextInt();
      int A[] = new int[n];
      for (int i = 0; i < n; i++) {
        A[i] = sc.nextInt();
      }
      Integer dp[][] = new Integer[k + 1][n + 1];
      System.out.println(helper(A, 0, k, dp));
    }
  }
}
