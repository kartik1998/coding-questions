package Dynamic_Programming;

import java.util.Scanner;

// Given a number n, count minimum steps to minimise it to 1 according to the following criteria:
//
//If n is divisible by 2 then we may reduce n to n/2.
//If n is divisible by 3 then you may reduce n to n/3.
//Decrement n by 1.
public class Minimum_steps_to_minimize_n_as_per_given_condition {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int dp[] = new int[n + 1];
      for (int i = 2; i <= n; i++) {
        if (i % 2 == 0 && i % 3 == 0) {
          dp[i] = Math.min(dp[i - 1], Math.min(dp[i / 2], dp[i / 3])) + 1;
        } else if (i % 2 == 0) {
          dp[i] = Math.min(dp[i - 1], dp[i / 2]) + 1;
        } else if (i % 3 == 0) {
          dp[i] = Math.min(dp[i - 1], dp[i / 3]) + 1;
        } else {
          dp[i] = dp[i - 1] + 1;
        }
      }
      System.out.println(dp[n]);
    }
  }
}
