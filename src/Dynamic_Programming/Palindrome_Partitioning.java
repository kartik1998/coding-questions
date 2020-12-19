package Dynamic_Programming;

import java.util.Scanner;

public class Palindrome_Partitioning {

  public static boolean check(String s, int l, int r) {
    for (int i = l, j = r; i < j; i++, j--) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
    }
    return true;
  }

  public static int helper(String s, int l, int r, Integer dp[]) {
    if (check(s, l, r)) {
      return dp[l] = 0;
    }
    if (dp[l] != null) {
      return dp[l];
    }
    int min = Integer.MAX_VALUE;
    for (int i = l; i < r; i++) {
      if (check(s, l, i)) {
        min = Math.min(1 + helper(s, i + 1, r, dp), min);
      }
    }
    return dp[l] = min;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      String s = sc.next();
      Integer dp[] = new Integer[s.length() + 1];
      System.out.println(helper(s, 0, s.length() - 1, dp));
    }
  }
}
