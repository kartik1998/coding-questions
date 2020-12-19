package Dynamic_Programming;

public class Count_Palindromic_Substrings_LeetCode {

  public boolean check(String S, int l, int r) {
    for (int i = l, j = r; i < j; i++, j--) {
      if (S.charAt(i) != S.charAt(j)) {
        return false;
      }
    }
    return true;
  }

  public int helper(String S, int l, int r, Integer dp[][]) {
    if (l > r) {
      return 0;
    }
    if (dp[l][r] != null) {
      return dp[l][r];
    }
    if (check(S, l, r)) {
      return (
        dp[l][r] =
          1 +
          helper(S, l + 1, r, dp) +
          helper(S, l, r - 1, dp) -
          helper(S, l + 1, r - 1, dp)
      );
    }
    return (
      dp[l][r] =
        helper(S, l + 1, r, dp) +
        helper(S, l, r - 1, dp) -
        helper(S, l + 1, r - 1, dp)
    );
  }

  public int countSubstrings(String S) {
    Integer dp[][] = new Integer[S.length() + 1][S.length() + 1];
    return helper(S, 0, S.length() - 1, dp);
  }
}
