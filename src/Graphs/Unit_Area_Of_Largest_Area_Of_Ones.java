package Graphs;

import java.util.Scanner;

public class Unit_Area_Of_Largest_Area_Of_Ones {

  static int count = 0;
  static int dx[] = { 0, 0, -1, 1, 1, 1, -1, -1 };
  static int dy[] = { 1, -1, 0, 0, 1, -1, 1, -1 };

  static boolean isSafe(
    int x,
    int y,
    int n,
    int m,
    boolean vis[][],
    int A[][]
  ) {
    if (
      x >= 0 && x < n && y >= 0 && y < m && vis[x][y] == false && A[x][y] == 1
    ) {
      return true;
    }
    return false;
  }

  static int findAreaUtil(int n, int m, int A[][], boolean vis[][]) {
    int max = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (A[i][j] == 1 && vis[i][j] == false) {
          count = 0;
          dfs(A, i, j, n, m, vis);
          max = Math.max(max, count);
        }
      }
    }
    return max;
  }

  static void dfs(int A[][], int x, int y, int n, int m, boolean vis[][]) {
    vis[x][y] = true;
    count++;
    for (int i = 0; i < 8; i++) {
      int X = x + dx[i];
      int Y = y + dy[i];
      if (isSafe(X, Y, n, m, vis, A)) {
        dfs(A, X, Y, n, m, vis);
      }
    }
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
      boolean vis[][] = new boolean[n][m];
      System.out.println(findAreaUtil(n, m, A, vis));
    }
  }
}
