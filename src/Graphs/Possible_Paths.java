package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

// Question Link : https://practice.geeksforgeeks.org/problems/possible-paths/0/?track=graph&batchId=126

// This Solution is wrong!
class Graph{
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    int N;
    public Graph(int N){
        for(int i=0 ; i<N;i++){
            adj.add(new ArrayList<>());
        }
        this.N = N;
    }
    public void setEdge(int u,int v){
        adj.get(u).add(v);
    }
}
public class Possible_Paths {
    static int count = 0;
    public static void dfs(ArrayList<ArrayList<Integer>> adj,int U,int V,int K,boolean vis[]){
        vis[U] = true;
        if(U==V && K==0){
            count++;
            return;
        }else if(K==0){
            return;
        }
        for(int i:adj.get(U)){
            if(!vis[i]){
                dfs(adj,i,V,K-1,vis);
            }
        }
        vis[U] = false;
    }
    public static int countPaths(Graph graph,int U,int V,int K){
        boolean vis[] = new boolean[graph.N];
        dfs(graph.adj,U,V,K,vis);
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            int N = sc.nextInt();
            Graph graph = new Graph(N);
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(sc.nextInt()==1){
                        graph.setEdge(i,j);
                    }
                }
            }
            int U = sc.nextInt() , V = sc.nextInt() , K = sc.nextInt();
            System.out.println(countPaths(graph,U,V,K));
            count = 0;
        }
    }
}
