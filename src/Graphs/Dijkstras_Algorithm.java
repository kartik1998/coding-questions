package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1)
// and E number of edges.Find and print the shortest distance from the source vertex (i.e. Vertex 0) to all other vertices
// (including source vertex also) using Dijkstra's Algorithm.
//Print the ith vertex number and the distance from source in one line separated by space.
// Print different vertices in different lines.
public class Dijkstras_Algorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int E=sc.nextInt();
        int L[][]=new int[N][N];
        for(int i=0;i<E;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            int w=sc.nextInt();
            L[u][v]=w;
            L[v][u]=w;
        }
        Queue<Integer> q = new LinkedList<>();
        int d[]=new int[N];
        Arrays.fill(d,Integer.MAX_VALUE);
        d[0]=0;
        q.add(0);
        while(!q.isEmpty()){
            int u=q.remove();
            for(int i=1;i<N;i++){
                if(d[i]>d[u]+L[u][i] && L[u][i]!=0){
                    d[i]=d[u]+L[u][i];
                    q.add(i);
                }
            }
        }
        for(int i=0;i<N;i++){
            System.out.println(i+" "+d[i]);
        }
    }
}
