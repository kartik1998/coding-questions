package Dynamic_Programming;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Sum_Of_Average_Of_All_Subsets {

  public static double helper(
    int A[],
    int n,
    int sum,
    int ct,
    Double dp[][][]
  ) {
    if (n == 0) {
      if (ct == 0) {
        return 0;
      }
      return (double) sum / ct;
    }
    if (dp[n][sum][ct] != null) {
      return dp[n][sum][ct];
    }
    return (
      dp[n][sum][ct] =
        helper(A, n - 1, sum + A[n - 1], ct + 1, dp) +
        helper(A, n - 1, sum, ct, dp)
    );
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int N = sc.nextInt();
      int A[] = new int[N];
      int sum = 0;
      for (int i = 0; i < N; i++) {
        A[i] = sc.nextInt();
        sum += A[i];
      }
      Double dp[][][] = new Double[N + 1][sum + 1][N + 1];
      double x = helper(A, N, 0, 0, dp);
      System.out.printf("%.6f", x);
      System.out.println();
    }
  }
}
