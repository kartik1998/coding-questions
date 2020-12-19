package Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

// https://practice.geeksforgeeks.org/problems/pizza-mania/0
public class Pizza_Mania {

  static Integer dp[] = new Integer[600];

  public static int helper(int X, int S, int M, int L, int x, int y, int z) {
    if (X <= 0) {
      return 0;
    }
    if (dp[X] != null) {
      return dp[X];
    }
    int a = x + helper(X - S, S, M, L, x, y, z);
    int b = y + helper(X - M, S, M, L, x, y, z);
    int c = z + helper(X - L, S, M, L, x, y, z);
    return dp[X] = Math.min(a, Math.min(b, c));
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int X = sc.nextInt();
      int S = sc.nextInt();
      int M = sc.nextInt();
      int L = sc.nextInt();
      int CS = sc.nextInt(), CM = sc.nextInt(), CL = sc.nextInt();
      System.out.println(helper(X, S, M, L, CS, CM, CL));
      Arrays.fill(dp, null);
    }
  }
}
