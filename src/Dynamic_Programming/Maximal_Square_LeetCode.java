package Dynamic_Programming;

import java.util.Scanner;
import sun.tools.jstat.Scale;

public class Maximal_Square_LeetCode {

  public int maximalSquare(char[][] A) {
    if (A.length == 0) {
      return 0;
    }
    int max = 0;
    int n = A.length;
    int m = A[0].length;
    int dp[][] = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (i == 0 || j == 0) {
          if (A[i][j] == '1') {
            dp[i][j] = 1;
          }
        } else {
          if (A[i][j] == '1') {
            dp[i][j] =
              Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) +
              1;
          }
        }
        max = Math.max(max, dp[i][j]);
      }
    }
    return max * max;
  }
}
