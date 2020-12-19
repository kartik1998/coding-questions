package Dynamic_Programming;

import java.util.Scanner;

public class Longest_Palindromic_Substring {

  static String ans = "";

  public static boolean check(String s, int l, int r) {
    for (int i = l, j = r; i < j; i++, j--) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
    }
    return true;
  }

  public static int helper(String s, int l, int r, Integer dp[][]) {
    if (l > r) {
      return 0;
    }
    if (dp[l][r] != null) {
      return dp[l][r];
    }
    if (check(s, l, r)) {
      if (ans.length() < r - l + 1) {
        ans = s.substring(l, r + 1);
      }
      return dp[l][r] = r - l + 1;
    }
    return (
      dp[l][r] = Math.max(helper(s, l + 1, r, dp), helper(s, l, r - 1, dp))
    );
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      String s = sc.next();
      int n = s.length();
      Integer dp[][] = new Integer[n + 1][n + 1];
      int k = helper(s, 0, n - 1, dp);
      System.out.println(ans);
      System.out.println(k);
      ans = "";
    }
  }
}
