package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class dfs_graph {
    public static void dfs(List<List<Integer>> adj,int s,boolean visited[]){
        System.out.print(s+" ");
        visited[s]=true;
        for(int i:adj.get(s)){
            if(!visited[i]){
                dfs(adj,i,visited);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int e=sc.nextInt();
            List<List<Integer>> adj = new ArrayList<>();
            for(int i=0;i<n;i++){
                adj.add(new ArrayList<>());
            }
            for(int i=0;i<e;i++){
                int u=sc.nextInt();
                int v=sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            boolean visited[]=new boolean[n];
            for(int i=0;i<n;i++){
                if(!visited[i]){
                    dfs(adj,i,visited);
                }
            }
        }
    }
}
