package Dynamic_Programming;

public class House_Robber_2_LeetCode {

  static class Solution {

    public int rob(int[] A) {
      Integer dp[] = new Integer[A.length + 1];
      return helper(A, A.length, true, dp);
    }

    public int helper(int A[], int n, boolean collect, Integer dp[]) {
      if (n == 0) {
        return 0;
      }
      if (n == 1) {
        if (collect) {
          return A[n - 1];
        }
        return 0;
      }
      if (dp[n] != null) {
        return dp[n];
      }
      if (n == A.length) {
        return (
          dp[n] =
            Math.max(
              helper(A, n - 2, false, dp) + A[n - 1],
              helper(A, n - 1, true, dp)
            )
        );
      } else {
        return (
          dp[n] =
            Math.max(
              helper(A, n - 2, collect, dp) + A[n - 1],
              helper(A, n - 1, collect, dp)
            )
        );
      }
    }
  }
}
