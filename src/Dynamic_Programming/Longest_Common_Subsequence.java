package Dynamic_Programming;

import java.util.Scanner;

public class Longest_Common_Subsequence {

  public static int longestCommonSubsequence(String a, String b) {
    int dp[][] = new int[a.length() + 1][b.length() + 1];
    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[i].length; j++) {
        if (a.charAt(i - 1) == b.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[a.length()][b.length()];
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String a = sc.next(), b = sc.next();
    System.out.println(longestCommonSubsequence(a, b));
  }
}
