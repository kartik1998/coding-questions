package Graphs;

import java.util.Scanner;

// Given a 2D screen, location of a pixel in the screen ie(x,y) and a color(K),
// your task is to replace color of the given pixel and all adjacent(excluding diagonally adjacent)
// same colored pixels with the given color K.
public class Flood_Fill {
    static int dx[]={0,0,1,-1};
    static int dy[]={1,-1,0,0};
    public static boolean isSafe(int x,int y,int n,int m,int A[][],int num){
        if(x>=0 && x<n && y>=0 && y<m && A[x][y]==num){
            return true;
        }
        return false;
    }
    public static void dfs(int A[][],int x,int y,int k,int num,int n,int m){
        A[x][y]=k;
        for(int i=0;i<4;i++){
            int X=x+dx[i];
            int Y=y+dy[i];
            if(isSafe(X,Y,n,m,A,num)){
                dfs(A,X,Y,k,num,n,m);
            }
        }
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt(),m=sc.nextInt();
            int A[][]=new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    A[i][j]=sc.nextInt();
                }
            }
            int x=sc.nextInt(),y=sc.nextInt(),k=sc.nextInt();
            dfs(A,x,y,k,A[x][y],n,m);
            for(int i=0;i<A.length;i++){
                for(int j=0;j<A[i].length;j++){
                    System.out.print(A[i][j]+" ");
                }
            }
            System.out.println();

        }
    }
}
