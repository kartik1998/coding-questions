package Dynamic_Programming;

import java.util.Scanner;

public class Minimum_Points_To_Reach_Destination {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int A[][] = new int[n][m];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          A[i][j] = sc.nextInt();
        }
      }
      int dp[][] = new int[n][m];
      for (int i = n - 1; i >= 0; i--) {
        for (int j = m - 1; j >= 0; j--) {
          if (i == n - 1 && j == m - 1) {
            if (A[i][j] >= 0) {
              dp[i][j] = 1;
            } else {
              dp[i][j] = Math.abs(A[i][j]) + 1;
            }
          } else if (j == m - 1) {
            dp[i][j] = Math.max(1, dp[i + 1][j] - A[i][j]);
          } else if (i == n - 1) {
            dp[i][j] = Math.max(1, dp[i][j + 1] - A[i][j]);
          } else {
            int min = Math.min(dp[i + 1][j], dp[i][j + 1]);
            dp[i][j] = Math.max(1, min - A[i][j]);
          }
        }
      }
      System.out.println(dp[0][0]);
    }
  }
}
