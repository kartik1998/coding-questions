package Graphs;

import java.util.ArrayList;
import java.util.Scanner;
// Anwer = nC2 - Summation of xC2's of all connected components
// basically we just have to select two people hence nC2;
// Those people shouldnt be of same country hence nC2 - (number ways to get 2 people from same country ka summation)
public class Journey_To_The_Moon_HackerRank {
    static int count=0;
    public static void dfs(ArrayList<ArrayList<Integer>> adj,boolean vis[],int s){
        vis[s]=true;
        count++;
        for(int i:adj.get(s)){
            if(!vis[i]){
                dfs(adj,vis,i);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int e=sc.nextInt();
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i=0;i<n;i++){
                adj.add(new ArrayList<>());
            }
            for(int i=0;i<e;i++){
                int u=sc.nextInt();
                int v=sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            long res = (n*(n-1))/2;
            ArrayList<Integer> list = new ArrayList<>();
            boolean vis[]=new boolean[n];
            for(int i=0;i<n;i++){
                if(!vis[i]){
                    count=0;
                    dfs(adj,vis,i);
                    list.add(count);
                }
            }
            for(int i : list){
                res -= (i*(i-1))/2;
            }
            System.out.println(res);
        }
    }
}
