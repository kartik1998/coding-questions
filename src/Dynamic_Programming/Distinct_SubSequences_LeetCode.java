package Dynamic_Programming;

public class Distinct_SubSequences_LeetCode {

  class Solution {

    public int numDistinct(String S, String T) {
      int n = S.length(), m = T.length();
      Integer dp[][] = new Integer[n + 1][m + 1];
      return helper(S, T, n, m, dp);
    }

    public int helper(String S, String T, int n, int m, Integer dp[][]) {
      if (m == 0) {
        return 1;
      }
      if (n == 0) {
        return 0;
      }
      if (dp[n][m] != null) {
        return dp[n][m];
      }
      if (S.charAt(n - 1) == T.charAt(m - 1)) {
        return (
          dp[n][m] = helper(S, T, n - 1, m - 1, dp) + helper(S, T, n - 1, m, dp)
        );
      }
      return dp[n][m] = helper(S, T, n - 1, m, dp);
    }
  }
}
