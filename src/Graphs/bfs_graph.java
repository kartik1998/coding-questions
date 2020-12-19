package Graphs;

import java.util.*;

public class bfs_graph {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int e = sc.nextInt();
      List<List<Integer>> adj = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        adj.add(new ArrayList<>());
      }
      for (int i = 0; i < e; i++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        adj.get(u).add(v);
        adj.get(v).add(u);
      }
      boolean visited[] = new boolean[n];
      Queue<Integer> q = new LinkedList<>();
      q.add(0);
      visited[0] = true;
      while (!q.isEmpty()) {
        int s = q.remove();
        System.out.print(s + " ");
        for (int i : adj.get(s)) {
          if (!visited[i]) {
            q.add(i);
            visited[i] = true;
          }
        }
      }
    }
  }
}
