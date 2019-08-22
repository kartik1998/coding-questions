package Graphs;
// Given a boolean 2D matrix (0-based index), find whether there is path from (0,0) to (x,y) and if there is one path,
// print the minimum no of steps needed to reach it, else print -1 if the destination is not reachable.
// You may move in only four direction ie up, down, left and right. The path can only be created out of a cell
// if its value is 1.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class point{
    int x;
    int y;
    int level;
    point(int x,int y,int level){
        this.x=x;
        this.y=y;
        this.level=level;
    }
}
public class Shortest_Source_To_Destination_Path {
    public static boolean isSafe(int x,int y,int m,int n,int arr[][],boolean visited[][]){
        if(x>=0 && x<m && y>=0 && y<n && arr[x][y]==1 && visited[x][y]==false){
            return true;
        }
        return false;
    }
    public static int bfs(int dist_x,int dist_y,int m,int n,int arr[][],boolean visited[][]){
        Queue<point> q = new LinkedList<point>();
        if(isSafe(0,0,m,n,arr,visited)){
            q.add(new point(0,0,0));
        }
        visited[0][0]=true;
        int dx[]={-1,1,0,0};
        int dy[]={0,0,-1,1};
        while(!q.isEmpty()){
            point p=q.remove();
            if(p.x==dist_x && p.y==dist_y){
                return p.level;
            }
            for(int i=0;i<4;i++){
                int ux=p.x+dx[i];
                int uy=p.y+dy[i];
                if(isSafe(ux,uy,m,n,arr,visited)){
                    q.add(new point(ux,uy,p.level+1));
                    visited[ux][uy]=true;
                }
            }
        }
        return -1;
    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            String s[]=br.readLine().split(" ");
            int m=Integer.parseInt(s[0]);
            int n=Integer.parseInt(s[1]);
            String str[]=br.readLine().split(" ");
            int arr[][]=new int[m][n];
            int k=0;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=Integer.parseInt(str[k]);
                    k++;
                }
            }
            String l[]=br.readLine().split(" ");
            int x=Integer.parseInt(l[0]);
            int y=Integer.parseInt(l[1]);
            boolean visited[][]=new boolean[m][n];
            System.out.println(bfs(x,y,m,n,arr,visited));
        }
    }
}
