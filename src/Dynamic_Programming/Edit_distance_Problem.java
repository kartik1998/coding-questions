package Dynamic_Programming;

import java.util.Scanner;

public class Edit_distance_Problem {

  public static int minDistance(String A, String B) {
    int n = A.length(), m = B.length();
    Integer dp[][] = new Integer[n + 1][m + 1];
    return helper(A, B, A.length(), B.length(), dp);
  }

  public static int helper(String A, String B, int n, int m, Integer dp[][]) {
    if (n == 0) {
      return dp[n][m] = m;
    }
    if (m == 0) {
      return dp[n][m] = n;
    }
    if (dp[n][m] != null) {
      return dp[n][m];
    }
    if (A.charAt(n - 1) == B.charAt(m - 1)) {
      return dp[n][m] = helper(A, B, n - 1, m - 1, dp);
    }
    return (
      dp[n][m] =
        Math.min(
          helper(A, B, n - 1, m - 1, dp),
          Math.min(helper(A, B, n - 1, m, dp), helper(A, B, n, m - 1, dp))
        ) +
        1
    );
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String A = sc.next(), B = sc.next();
    System.out.println(minDistance(A, B));
  }
}
