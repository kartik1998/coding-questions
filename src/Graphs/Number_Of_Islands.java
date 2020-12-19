package Graphs;

import java.util.Scanner;

public class Number_Of_Islands {

  static int dx[] = { 0, 0, 1, -1, 1, 1, -1, -1 };
  static int dy[] = { 1, -1, 0, 0, 1, -1, 1, -1 };

  public static boolean isSafe(int A[][], int x, int y, int n, int m) {
    if (x >= 0 && x < n && y >= 0 && y < m && A[x][y] == 1) {
      return true;
    }
    return false;
  }

  public static void dfs(int A[][], int x, int y, int n, int m) {
    A[x][y] = 0;
    for (int i = 0; i < 8; i++) {
      int X = x + dx[i];
      int Y = y + dy[i];
      if (isSafe(A, X, Y, n, m)) {
        dfs(A, X, Y, n, m);
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt(), m = sc.nextInt();
      int A[][] = new int[n][m];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          A[i][j] = sc.nextInt();
        }
      }
      int count = 0;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (A[i][j] == 1) {
            dfs(A, i, j, n, m);
            count++;
          }
        }
      }
      System.out.println(count);
    }
  }
}
