package HackerEarth;

import java.util.Scanner;

public class Field_Of_Dreams {

  static int dx[] = { 0, 0, 1, -1 };
  static int dy[] = { 1, -1, 0, 0 };

  public static boolean check(
    char A[][],
    int x,
    int y,
    int N,
    int M,
    boolean vis[][]
  ) {
    vis[x][y] = true;
    if (x == N - 1 && y == M - 1) {
      return true;
    }
    for (int i = 0; i < 4; i++) {
      int X = x + dx[i];
      int Y = y + dy[i];
      if (X >= 0 && X < N && Y >= 0 && Y < M && !vis[X][Y] && A[X][Y] == 'g') {
        if (check(A, X, Y, N, M, vis)) {
          return true;
        }
      }
    }
    return false;
  }

  public static void clear(boolean vis[][]) {
    for (int i = 0; i < vis.length; i++) {
      for (int j = 0; j < vis[i].length; j++) {
        vis[i][j] = false;
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(), M = sc.nextInt();
    char A[][] = new char[N][M];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        A[i][j] = sc.next().charAt(0);
      }
    }
    boolean vis[][] = new boolean[N][M];
    int ans = 2;
    if (!check(A, 0, 0, N, M, vis)) {
      System.out.println(0);
    } else {
      clear(vis);
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (i == 0 && j == 0 || i == N - 1 && j == M - 1) {
            continue;
          } else {
            if (A[i][j] == 'g') {
              A[i][j] = 'd';
              if (check(A, 0, 0, N, M, vis)) {
                ans = 1;
                break;
              }
              A[i][j] = 'g';
              clear(vis);
            }
          }
        }
      }
    }
    System.out.println(ans);
  }
}
