package HackerEarth;

import java.util.Scanner;

public class Palindrome_Count {

  public static boolean check(char s[], int l, int r) {
    for (int i = l, j = r; i < j; i++, j--) {
      if (s[i] != s[j]) {
        return false;
      }
    }
    return true;
  }

  public static int helper(char s[], int l, int r, Integer dp[][]) {
    if (l > r) {
      return 0;
    }
    if (dp[l][r] != null) {
      return dp[l][r];
    }
    if (check(s, l, r)) {
      return (
        dp[l][r] =
          1 +
          helper(s, l + 1, r, dp) +
          helper(s, l, r - 1, dp) -
          helper(s, l + 1, r - 1, dp)
      );
    } else {
      return (
        dp[l][r] =
          helper(s, l + 1, r, dp) +
          helper(s, l, r - 1, dp) -
          helper(s, l + 1, r - 1, dp)
      );
    }
  }

  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    char s[] = sc.next().toCharArray();
    Integer dp[][] = new Integer[s.length + 1][s.length + 1];
    System.out.println(helper(s, 0, s.length - 1, dp));
  }
}
