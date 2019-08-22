package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Topological_Sort {
    public static void dfs(List<List<Integer>> adj,int s,boolean visited[],Stack<Integer> st){
        visited[s]=true;
        for(int i:adj.get(s)){
            if(!visited[s]){
                dfs(adj,s,visited,st);
            }
        }
        st.push(s);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0) {
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
            boolean visited[]=new boolean[n];
            Stack<Integer> s = new Stack<>();
            for(int i=0;i<n;i++){
                if(!visited[i]){
                    dfs(adj,i,visited,s);
                }
            }
            while(!s.isEmpty()){
                System.out.print(s.pop()+" ");
            }
        }
    }
}
