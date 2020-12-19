package Dynamic_Programming;

import java.util.Scanner;

public class Integer_Break_Leetcode {

  public static int helper(int N, Integer dp[]) {
    if (N == 0) {
      return 1;
    }
    if (dp[N] != null) {
      return dp[N];
    }
    int max = 0;
    for (int i = 1; i <= N; i++) {
      max = Math.max(max, i * helper(N - i, dp));
    }
    return dp[N] = max;
  }

  public static int integerBreak(int n) {
    Integer dp[] = new Integer[n + 1];
    if (n == 2) {
      return 1;
    } else if (n == 3) {
      return 2;
    } else {
      return helper(n, dp);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println(integerBreak(sc.nextInt()));
  }
}
