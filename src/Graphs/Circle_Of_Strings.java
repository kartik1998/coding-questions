package Graphs;

import java.lang.reflect.Array;
import java.util.*;

// Given an array of strings A[], determine if the strings can be chained together to form a circle. A
//string X can be chained together with another string Y if the last character of X is same as first
//character of Y. If every string of the array can be chained, it will form a circle.
//
//For eg for the array arr[] = {"for", "geek", "rig", "kaf"} the answer will be Yes as the
// given strings can be chained as "for", "rig", "geek" and "kaf"
public class Circle_Of_Strings {

  public static int SCC(ArrayList<ArrayList<Integer>> adj) {
    Stack<Integer> stack = new Stack<>();
    boolean visited[] = new boolean[adj.size()];
    ArrayList<ArrayList<Integer>> list = getTranspose(adj);
    for (int i = 0; i < adj.size(); i++) {
      if (!visited[i]) {
        topSort(adj, i, visited, stack);
      }
    }
    int count = 0;
    Arrays.fill(visited, false);
    while (!stack.isEmpty()) {
      int i = stack.pop();
      if (!visited[i]) {
        count++;
        dfs(list, i, visited);
      }
    }
    return count;
  }

  public static void topSort(
    ArrayList<ArrayList<Integer>> adj,
    int s,
    boolean vis[],
    Stack<Integer> stack
  ) {
    vis[s] = true;
    for (int i : adj.get(s)) {
      if (!vis[i]) {
        topSort(adj, i, vis, stack);
      }
    }
    stack.push(s);
  }

  public static void dfs(
    ArrayList<ArrayList<Integer>> adj,
    int s,
    boolean vis[]
  ) {
    vis[s] = true;
    for (int i : adj.get(s)) {
      if (!vis[i]) {
        dfs(adj, i, vis);
      }
    }
  }

  public static ArrayList<ArrayList<Integer>> getTranspose(
    ArrayList<ArrayList<Integer>> adj
  ) {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    for (int i = 0; i < adj.size(); i++) {
      list.add(new ArrayList<>());
    }
    for (int i = 0; i < adj.size(); i++) {
      for (int j = 0; j < adj.get(i).size(); j++) {
        list.get(adj.get(i).get(j)).add(i);
      }
    }
    return list;
  }

  public static boolean check(ArrayList<ArrayList<Integer>> adj) {
    int n = adj.size();
    int A[][] = new int[n][n];
    for (int i = 0; i < adj.size(); i++) {
      for (int j = 0; j < adj.get(i).size(); j++) {
        A[i][adj.get(i).get(j)] = 1;
      }
    }
    int row[] = new int[n];
    int col[] = new int[n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (A[i][j] == 1) {
          row[i]++;
        }
      }
    }
    for (int j = 0; j < n; j++) {
      for (int i = 0; i < n; i++) {
        if (A[i][j] == 1) {
          col[j]++;
        }
      }
    }
    for (int i = 0; i < n; i++) {
      if (row[i] != col[i]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      String A[] = new String[n];
      for (int i = 0; i < n; i++) {
        A[i] = sc.next();
      }
      ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        adj.add(new ArrayList<>());
      }
      for (int i = 0; i < n; i++) {
        String a = A[i];
        int la = a.length();
        for (int j = i; j < n; j++) {
          if (i == j) {
            if (a.charAt(la - 1) == a.charAt(0)) {
              adj.get(i).add(i);
            }
          }
          String b = A[j];
          int lb = b.length();
          if (a.charAt(la - 1) == b.charAt(0)) {
            adj.get(i).add(j);
          }
          if (b.charAt(lb - 1) == a.charAt(0)) {
            adj.get(j).add(i);
          }
        }
      }
      if (SCC(adj) == 1 && check(adj)) {
        System.out.println(1);
      } else {
        System.out.println(0);
      }
    }
  }
}
