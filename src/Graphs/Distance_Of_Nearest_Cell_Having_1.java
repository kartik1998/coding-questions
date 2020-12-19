package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Distance_Of_Nearest_Cell_Having_1 {

  static int dx[] = { 0, 0, 1, -1 };
  static int dy[] = { 1, -1, 0, 0 };

  static class Pair {

    int x, y;

    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static int minDistance(int A[][], int x, int y, int n, int m) {
    Queue<Pair> q = new LinkedList<>();
    if (A[x][y] == 1) {
      return 0;
    }
    boolean vis[][] = new boolean[n][m];
    q.add(new Pair(x, y));
    vis[x][y] = true;
    while (!q.isEmpty()) {
      Pair p = q.remove();
      if (A[p.x][p.y] == 1) {
        return Math.abs(p.x - x) + Math.abs(p.y - y);
      }
      for (int i = 0; i < 4; i++) {
        int X = p.x + dx[i];
        int Y = p.y + dy[i];
        if (X >= 0 && X < n && Y >= 0 && Y < m) {
          if (!vis[X][Y]) {
            q.add(new Pair(X, Y));
            vis[X][Y] = true;
          }
        }
      }
    }
    return -1;
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
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          System.out.print(minDistance(A, i, j, n, m) + " ");
        }
      }
      System.out.println();
    }
  }
}
