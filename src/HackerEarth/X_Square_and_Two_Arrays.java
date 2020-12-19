package HackerEarth;

import java.util.Scanner;

public class X_Square_and_Two_Arrays {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(), q = sc.nextInt();
    int A[] = new int[n];
    int B[] = new int[n];
    for (int i = 0; i < n; i++) {
      A[i] = sc.nextInt();
    }
    for (int i = 0; i < n; i++) {
      B[i] = sc.nextInt();
    }
    long dp[][] = new long[2][n];
    for (int j = 0; j < n; j++) {
      if (j == 0) {
        dp[0][j] = A[j];
        dp[1][j] = B[j];
      } else {
        dp[0][j] = dp[1][j - 1] + A[j];
        dp[1][j] = dp[0][j - 1] + B[j];
      }
    }
    while (q-- > 0) {
      int x = sc.nextInt();
      int l = sc.nextInt() - 1;
      int r = sc.nextInt() - 1;
      long ans;
      if (x == 1) {
        if ((r - l) % 2 == 0) {
          if (l == 0) {
            ans = dp[0][r];
          } else {
            ans = dp[0][r] - dp[1][l - 1];
          }
        } else {
          if (l == 0) {
            ans = dp[1][r];
          } else {
            ans = dp[1][r] - dp[1][l - 1];
          }
        }
      } else {
        if ((r - l) % 2 == 0) {
          if (l == 0) {
            ans = dp[1][r];
          } else {
            ans = dp[1][r] - dp[0][l - 1];
          }
        } else {
          if (l == 0) {
            ans = dp[0][r];
          } else {
            ans = dp[0][r] - dp[0][l - 1];
          }
        }
      }
      System.out.println(ans);
    }
  }
}
