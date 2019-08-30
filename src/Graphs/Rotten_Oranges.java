package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Rotten_Oranges {
    static int dx[]={0,0,1,-1};
    static int dy[]={1,-1,0,0};
    public static boolean isSafe(int x,int y,int n,int m,int A[][]){
        if(x>=0 && x<n && y>=0 && y<m && A[x][y]==1){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt(),m=sc.nextInt();
            int A[][]=new int[n][m];
            Queue<Pair> q = new LinkedList<>();
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    A[i][j]=sc.nextInt();
                    if(A[i][j]==2){
                        q.add(new Pair(i,j));
                    }
                }
            }
            int count=0;
            while(!q.isEmpty()){
                int N=q.size();
                boolean flag=false;
                while(N-->0){
                    Pair p=q.remove();
                    for(int i=0;i<4;i++){
                        int x=p.x+dx[i];
                        int y=p.y+dy[i];
                        if(isSafe(x,y,n,m,A)){
                            q.add(new Pair(x,y));
                            flag=true;
                            A[x][y]=2;
                        }
                    }
                }
                if(flag) {
                    count++;
                }
            }
            boolean flag=true;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(A[i][j]==1){
                        flag=false;
                    }
                }
            }
            if(!flag){
                System.out.println(-1);
                continue;
            }
            System.out.println(count);
        }
    }
}
