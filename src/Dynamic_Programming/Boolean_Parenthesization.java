package Dynamic_Programming;

import java.util.Scanner;

public class Boolean_Parenthesization {

  public static int helper(
    char s[],
    int i,
    int j,
    boolean isTrue,
    Integer dp[][][]
  ) {
    if (i == j) {
      if (isTrue) {
        return dp[i][j][1] = s[i] == 'T' ? 1 : 0;
      } else {
        return dp[i][j][0] = s[i] == 'F' ? 1 : 0;
      }
    }
    if (dp[i][j][isTrue ? 1 : 0] != null) {
      return dp[i][j][isTrue ? 1 : 0];
    }
    int ways = 0;
    for (int k = i + 1; k < j; k += 2) {
      int lt = helper(s, i, k - 1, true, dp);
      int lf = helper(s, i, k - 1, false, dp);
      int rt = helper(s, k + 1, j, true, dp);
      int rf = helper(s, k + 1, j, false, dp);
      if (s[k] == '|') {
        if (isTrue) {
          ways += lt * rt + lt * rf + rt * lf;
        } else {
          ways += lf * rf;
        }
      } else if (s[k] == '&') {
        if (isTrue) {
          ways += lt * rt;
        } else {
          ways += lf * rf + lt * rf + lf * rt;
        }
      } else {
        if (isTrue) {
          ways += lt * rf + lf * rt;
        } else {
          ways += lt * rt + lf * rf;
        }
      }
    }
    return dp[i][j][isTrue ? 1 : 0] = ways;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      String str = sc.next();
      char s[] = str.toCharArray();
      Integer dp[][][] = new Integer[n + 1][n + 1][2];
      System.out.println(helper(s, 0, n - 1, true, dp));
    }
  }
}
