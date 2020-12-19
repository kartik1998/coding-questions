package Dynamic_Programming;

import java.util.Scanner;

//Given n dice each with m faces, numbered from 1 to m, find the number of ways to get sum X.
// X is the summation of values on each face when all the dice are thrown.
public class Dice_Throwing_Problem {

  public static long helper(int n, int m, int target, Long dp[][]) {
    if (n == 0 && target == 0) {
      return dp[n][target] = 1L;
    }
    if (n == 0 || target <= 0) {
      return 0;
    }
    if (dp[n][target] != null) {
      return dp[n][target];
    }
    long sum = 0;
    for (int i = 1; i <= m; i++) {
      sum += helper(n - 1, m, target - i, dp);
    }
    return dp[n][target] = sum;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int m = sc.nextInt();
      int n = sc.nextInt();
      int target = sc.nextInt();
      Long dp[][] = new Long[n + 1][target + 1];
      System.out.println(helper(n, m, target, dp));
    }
  }
}
