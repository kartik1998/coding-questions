package Dynamic_Programming;

import java.util.Scanner;

public class Sam_And_Substrings_HackerRank {

  public static int substrings(String n) {
    Long dp[][] = new Long[n.length() + 1][n.length() + 1];
    long mod = (long) (1e9 + 7);
    return (int) (helper(n, 0, n.length() - 1, dp) % mod);
  }

  public static long helper(String s, int l, int r, Long dp[][]) {
    if (l > r) {
      return 0;
    }
    if (l == r) {
      return dp[l][r] = (long) (s.charAt(l) - '0');
    }
    if (dp[l][r] != null) {
      return dp[l][r];
    }
    return (
      dp[l][r] =
        Integer.parseInt(s.substring(l, r + 1)) +
        helper(s, l + 1, r, dp) +
        helper(s, l, r - 1, dp) -
        helper(s, l + 1, r - 1, dp)
    );
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println(substrings(sc.next()));
  }
}
