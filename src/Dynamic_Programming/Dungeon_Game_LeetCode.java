package Dynamic_Programming;

public class Dungeon_Game_LeetCode {
    class Solution {
        public int calculateMinimumHP(int[][] A) {
            int n = A.length;
            int m = A[0].length;
            int dp[][] = new int[n][m];
            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    if (i == n - 1 && j == m - 1) {
                        if (A[i][j] >= 0) {
                            dp[i][j] = 1;
                        } else {
                            dp[i][j] = Math.abs(A[i][j]) + 1;
                        }
                    } else if (i == n - 1) {
                        dp[i][j] = Math.max(1, dp[i][j + 1] - A[i][j]);
                    } else if (j == m - 1) {
                        dp[i][j] = Math.max(1, dp[i + 1][j] - A[i][j]);
                    } else {
                        int minOnExit = Math.min(dp[i + 1][j], dp[i][j + 1]);
                        dp[i][j] = Math.max(1, minOnExit - A[i][j]);
                    }
                }
            }
            return dp[0][0];
        }
    }
}
