package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Snake_And_Ladder {

  static class Pair {

    int x, y;

    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int A[] = new int[31];
      for (int i = 0; i < n; i++) {
        A[sc.nextInt()] = sc.nextInt();
      }
      boolean visited[] = new boolean[31];
      Queue<Pair> q = new LinkedList<>();
      q.add(new Pair(1, 0));
      while (!q.isEmpty()) {
        Pair p = q.remove();
        for (int x = p.x + 1; x <= p.x + 6; x++) {
          if (x < 31 && A[x] == 0) {
            if (!visited[x]) {
              q.add(new Pair(x, p.y + 1));
              visited[x] = true;
            }
          } else if (x < 31) {
            if (!visited[A[x]]) {
              q.add(new Pair(A[x], p.y + 1));
              visited[A[x]] = true;
            }
          }
        }
        if (visited[30]) {
          int ans = p.y + 1;
          System.out.println(ans);
          break;
        }
      }
    }
  }
}
