package Dynamic_Programming;

import java.util.Scanner;

public class Max_Sum_Rectangle_In_2D_SubArray {

  public static int kadane(int A[]) {
    int curr = 0;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < A.length; i++) {
      curr += A[i];
      max = Math.max(max, curr);
      curr = Math.max(curr, 0);
    }
    return max;
  }

  public static int sum(int A[][], int i, int l, int r) {
    int sum = 0;
    for (int j = l; j <= r; j++) {
      sum += A[i][j];
    }
    return sum;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int A[][] = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        A[i][j] = sc.nextInt();
      }
    }
    int dp[] = new int[n];
    int sum = Integer.MIN_VALUE;
    for (int j = 0; j < m; j++) {
      for (int r = j; r < m; r++) {
        for (int i = 0; i < n; i++) {
          dp[i] = sum(A, i, j, r);
        }
        sum = Math.max(sum, kadane(dp));
      }
    }
    System.out.println(sum);
  }
}
