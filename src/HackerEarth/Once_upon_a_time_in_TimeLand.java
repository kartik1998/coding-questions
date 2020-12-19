package HackerEarth;

import java.util.Scanner;

public class Once_upon_a_time_in_TimeLand {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt(), k = sc.nextInt();
      int A[] = new int[n];
      for (int i = 0; i < n; i++) {
        A[i] = sc.nextInt();
      }
      long dp[] = new long[n + 1];
      for (int i = 1; i <= n; i++) {
        if (i - k - 1 >= 0) {
          dp[i] = Math.max(dp[i - 1], dp[i - k - 1] + A[i - 1]);
        } else {
          dp[i] = Math.max(dp[i - 1], A[i - 1]);
        }
      }
      System.out.println(dp[n]);
    }
  }
}
