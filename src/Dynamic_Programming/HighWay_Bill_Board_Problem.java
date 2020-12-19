package Dynamic_Programming;

import java.util.Scanner;

public class HighWay_Bill_Board_Problem {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int M = sc.nextInt();
      int n = sc.nextInt();
      int X[] = new int[n];
      for (int i = 0; i < n; i++) {
        X[i] = sc.nextInt();
      }
      int Revenue[] = new int[n];
      for (int i = 0; i < n; i++) {
        X[i] = sc.nextInt();
      }
      for (int i = 0; i < n; i++) {
        Revenue[i] = sc.nextInt();
      }
      int T = sc.nextInt();
      int dp[] = new int[M];
      int billBoards = 0;
      for (int i = 0; i < M; i++) {
        if (billBoards < n) {
          if (i == 0) {
            dp[i] = Revenue[i];
            billBoards++;
          } else {
            if (i <= T) {
              dp[i] = Math.max(dp[i - 1], Revenue[i]);
            } else {
              dp[i] = Math.max(dp[i - T - 1] + Revenue[i], dp[i - 1]);
            }
            if (dp[i] != dp[i - 1]) {
              billBoards++;
            }
          }
        } else {
          dp[i] = dp[i - 1];
        }
      }
    }
  }
}
