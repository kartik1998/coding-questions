package Dynamic_Programming;

import java.util.Scanner;

public class Valentine_Magic_Problem {

  public static long helper(
    int boys[],
    int girls[],
    int n,
    int m,
    Long dp[][]
  ) {
    if (n == 0) {
      return dp[n][m] = 0L;
    }
    if (m == 0) {
      return dp[n][m] = (long) Integer.MAX_VALUE;
    }
    if (dp[n][m] != null) {
      return dp[n][m];
    }
    long a =
      Math.abs(boys[n - 1] - girls[m - 1]) +
      helper(boys, girls, n - 1, m - 1, dp);
    long b = helper(boys, girls, n, m - 1, dp);
    return dp[n][m] = Math.min(a, b);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt(); // Number of Boys
      int m = sc.nextInt(); // NUmber of Girls  :  M > = N
      int boys_chocolates[] = new int[n];
      int girl_candies[] = new int[m];
      for (int i = 0; i < n; i++) {
        boys_chocolates[i] = sc.nextInt();
      }
      for (int i = 0; i < m; i++) {
        girl_candies[i] = sc.nextInt();
      }
      Long dp[][] = new Long[n + 1][m + 1];
      System.out.println(helper(boys_chocolates, girl_candies, n, m, dp));
    }
  }
}
