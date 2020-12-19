package Dynamic_Programming;

//You are given a bag of size W kg and you are provided costs of packets different weights of oranges in
// array cost[] where cost[i] is basically cost of ‘i’ kg packet of oranges. Where cost[i] = -1 means that
// ‘i’ kg packet of orange is unavailable
//Find the minimum total cost to buy exactly W kg oranges and if it is not possible to buy exactly W kg
// oranges then print -1. It may be assumed that there is infinite supply of all available packet types.
//Note : array starts from index 1.
import java.util.Scanner;

public class Minimum_cost_to_fill_given_weight_in_a_bag {

  public static long helper(int A[], int N, int W, Long dp[][]) {
    if (W == 0) {
      return dp[N][W] = 0L;
    }
    if (W < 0 || N == 0) {
      return Integer.MAX_VALUE;
    }
    if (dp[N][W] != null) {
      return dp[N][W];
    }
    if (A[N - 1] == -1 || N > W) {
      return dp[N][W] = helper(A, N - 1, W, dp);
    } else {
      return (
        dp[N][W] =
          Math.min(helper(A, N - 1, W, dp), helper(A, N, W - N, dp) + A[N - 1])
      );
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int N = sc.nextInt(), W = sc.nextInt();
      int A[] = new int[N];
      for (int i = 0; i < N; i++) {
        A[i] = sc.nextInt();
      }
      Long dp[][] = new Long[N + 1][W + 1];
      long x = helper(A, N, W, dp);
      if (x == Integer.MAX_VALUE) {
        System.out.println("-1");
      } else {
        System.out.println(x);
      }
    }
  }
}
