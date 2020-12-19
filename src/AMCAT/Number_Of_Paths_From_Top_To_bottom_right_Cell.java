package AMCAT;

import java.util.Scanner;

// (n+m-2)C(m-1)
public class Number_Of_Paths_From_Top_To_bottom_right_Cell {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(), m = sc.nextInt();
    long dp[][] = new long[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 1;
        } else {
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
      }
    }
    long mod = (long) (1e9 + 7);
    System.out.println(dp[n - 1][m - 1] % mod);
  }
}
