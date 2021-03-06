package Dynamic_Programming;

import java.util.Scanner;

public class Palindromic_substrings_count {

  public static boolean check(String str, int s, int e) {
    for (int i = s, j = e; i < j; i++, j--) {
      if (str.charAt(i) != str.charAt(j)) {
        return false;
      }
    }
    return true;
  }

  public static int helper(String str, int s, int e, Integer dp[][]) {
    if (s == e) {
      return dp[s][e] = 0;
    }
    if (e == s + 1) {
      if (str.charAt(s) == str.charAt(e)) {
        return dp[s][e] = 1;
      }
      return dp[s][e] = 0;
    }

    if (check(str, s, e)) {
      return (
        dp[s][e] =
          1 +
          helper(str, s + 1, e, dp) +
          helper(str, s, e - 1, dp) -
          helper(str, s + 1, e - 1, dp)
      );
    }
    return (
      dp[s][e] =
        helper(str, s + 1, e, dp) +
        helper(str, s, e - 1, dp) -
        helper(str, s + 1, e - 1, dp)
    );
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      String s = sc.next();
      Integer dp[][] = new Integer[s.length() + 1][s.length() + 1];
      System.out.println(helper(s, 0, s.length() - 1, dp));
    }
  }
}
