package Dynamic_Programming;

import java.util.Scanner;

// Find longest palindromic subsequenece and subtract it from String length.
public class MIn_Delettions_to_make_String_Palindrome {

  public static int lps(String str, int s, int e, Integer dp[][]) {
    if (s == e) {
      return dp[s][e] = 1;
    }
    if (e == s + 1) {
      if (str.charAt(s) == str.charAt(e)) {
        return dp[s][e] = 2;
      } else {
        return dp[s][e] = 1;
      }
    }
    if (dp[s][e] != null) {
      return dp[s][e];
    }
    if (str.charAt(s) == str.charAt(e)) {
      return dp[s][e] = 2 + lps(str, s + 1, e - 1, dp);
    }
    return dp[s][e] = Math.max(lps(str, s + 1, e, dp), lps(str, s, e - 1, dp));
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      String s = sc.next();
      Integer dp[][] = new Integer[s.length() + 1][s.length() + 1];
      System.out.println(s.length() - lps(s, 0, s.length() - 1, dp));
    }
  }
}
