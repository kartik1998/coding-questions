package Dynamic_Programming.Cost_Paths;

import java.util.Scanner;

public class Min_Cost_Path {

  public static long minCost(int A[][], int n, int m, int x, int y) {
    if (x < 0 || x >= n || y < 0 || y >= m) {
      return Integer.MAX_VALUE;
    }
    if (x == n - 1 && y == m - 1) {
      return 0;
    }
    return (
      Math.min(minCost(A, n, m, x + 1, y), minCost(A, n, m, x, y + 1)) + A[x][y]
    );
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int A[][] = new int[n][m];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          A[i][j] = sc.nextInt();
        }
      }
      System.out.println(minCost(A, n, m, 0, 0));
    }
  }
}
