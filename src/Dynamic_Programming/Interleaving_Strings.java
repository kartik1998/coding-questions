package Dynamic_Programming;

import java.util.Scanner;

public class Interleaving_Strings {

  public static boolean isInterleave(String A, String B, String S) {
    int a = A.length(), b = B.length(), n = S.length();
    Boolean dp[][][] = new Boolean[a + 1][b + 1][n + 1];
    return check(A, B, S, a, b, n, dp);
  }

  public static boolean check(
    String A,
    String B,
    String S,
    int a,
    int b,
    int n,
    Boolean dp[][][]
  ) {
    if (a == 0 && b == 0 && n == 0) {
      return dp[a][b][n] = true;
    }
    if (n == 0 || a == 0 && b == 0) {
      return dp[a][b][n] = false;
    }
    if (dp[a][b][n] != null) {
      return dp[a][b][n];
    }
    if (
      a != 0 &&
      b != 0 &&
      A.charAt(a - 1) == S.charAt(n - 1) &&
      B.charAt(b - 1) == S.charAt(n - 1)
    ) {
      return (
        dp[a][b][n] =
          check(A, B, S, a - 1, b, n - 1, dp) ||
          check(A, B, S, a, b - 1, n - 1, dp)
      );
    } else if (a != 0 && A.charAt(a - 1) == S.charAt(n - 1)) {
      return dp[a][b][n] = check(A, B, S, a - 1, b, n - 1, dp);
    } else if (b != 0 && B.charAt(b - 1) == S.charAt(n - 1)) {
      return dp[a][b][n] = check(A, B, S, a, b - 1, n - 1, dp);
    } else {
      return dp[a][b][n] = false;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      String A = sc.next(), B = sc.next(), C = sc.next();
      System.out.println(isInterleave(A, B, C));
    }
  }
}
