package Graphs;

import java.util.*;
import sun.tools.jstat.Scale;

public class Bi_Partite_Graph {

  public static boolean isBipartite(
    ArrayList<ArrayList<Integer>> adj,
    int color[],
    int s
  ) {
    color[s] = 0;
    Queue<Integer> q = new LinkedList<>();
    q.add(s);
    while (!q.isEmpty()) {
      int u = q.remove();
      for (int i : adj.get(u)) {
        if (color[i] == -1) {
          color[i] = 1 - color[u];
          q.add(i);
        } else if (color[i] == color[u]) {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int V = sc.nextInt();
      int E = sc.nextInt();
      ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
      for (int i = 0; i < V; i++) {
        adj.add(new ArrayList<>());
      }
      for (int i = 0; i < E; i++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        adj.get(u).add(v);
        adj.get(v).add(u);
      }
      int color[] = new int[V];
      Arrays.fill(color, -1);
      boolean ans = true;
      for (int i = 0; i < adj.size(); i++) {
        if (color[i] == -1) {
          if (!isBipartite(adj, color, i)) {
            ans = false;
            break;
          }
        }
      }
      System.out.println(ans);
    }
  }
}
