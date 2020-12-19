package Dynamic_Programming;

import java.util.Scanner;

public class Rod_Cutting {

  public static int rod_cut(int price[], int n, Integer dp[]) {
    if (n < 0) {
      return Integer.MIN_VALUE;
    }
    if (n == 0) {
      return dp[n] = 0;
    }
    if (dp[n] != null) {
      return dp[n];
    }
    int ans = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      int sub_res = price[i] + rod_cut(price, n - (i + 1), dp);
      ans = Math.max(ans, sub_res);
    }
    return dp[n] = ans;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int price[] = new int[n];
      for (int i = 0; i < n; i++) {
        price[i] = sc.nextInt();
      }
      Integer dp[] = new Integer[n + 1];
      System.out.println(rod_cut(price, n, dp));
    }
  }
}
