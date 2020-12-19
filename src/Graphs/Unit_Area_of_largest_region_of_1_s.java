package Graphs;

import java.util.Scanner;

public class Unit_Area_of_largest_region_of_1_s {

  static int count = 0;
  static int max = 0;
  static int dx[] = { 0, 0, 1, -1, 1, 1, -1, -1 };
  static int dy[] = { 1, -1, 0, 0, 1, -1, -1, 1 };

  public static boolean isSafe(int x, int y, int n, int m) {
    if (x >= 0 && x < n && y >= 0 && y < m) {
      return true;
    }
    return false;
  }

  public static void dfs(
    int arr[][],
    int x,
    int y,
    int n,
    int m,
    boolean visited[][]
  ) {
    visited[x][y] = true;
    count++;
    for (int i = 0; i < 8; i++) {
      int X = x + dx[i];
      int Y = y + dy[i];
      if (isSafe(X, Y, n, m) && arr[X][Y] == 1 && visited[X][Y] == false) {
        dfs(arr, X, Y, n, m, visited);
      }
    }
  }

  public static void area(int arr[][], int n, int m, boolean visited[][]) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (arr[i][j] == 1 && visited[i][j] == false) {
          dfs(arr, i, j, n, m, visited);
          if (count > max) {
            max = count;
          }
          count = 0;
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int arr[][] = new int[n][m];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          arr[i][j] = sc.nextInt();
        }
      }
      boolean visited[][] = new boolean[n][m];
      area(arr, n, m, visited);
      System.out.println(max);
      max = 0;
      count = 0;
    }
  }
}
