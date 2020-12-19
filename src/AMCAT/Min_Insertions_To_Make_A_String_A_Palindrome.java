package AMCAT;

import java.util.Scanner;

public class Min_Insertions_To_Make_A_String_A_Palindrome {

  public static int helper(String s, int l, int r, Integer dp[][]) {
    if (dp[l][r] != null) {
      return dp[l][r];
    }
    if (l == r) {
      return dp[l][r] = 0;
    }
    if (r == l + 1) {
      if (s.charAt(l) == s.charAt(r)) {
        return dp[l][r] = 0;
      }
      return dp[l][r] = 1;
    }
    if (s.charAt(l) == s.charAt(r)) {
      return dp[l][r] = helper(s, l + 1, r - 1, dp);
    }
    return (
      dp[l][r] = Math.min(helper(s, l + 1, r, dp), helper(s, l, r - 1, dp)) + 1
    );
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      String s = sc.next();
      Integer dp[][] = new Integer[s.length() + 1][s.length() + 1];
      System.out.println(helper(s, 0, s.length() - 1, dp));
    }
  }
}
