package Graphs;

// Given a N X N matrix (M) filled with 1, 0, 2, 3.
// The task is to find whether there is a path possible from source to destination,
// while traversing through blank cells only. You can traverse up, down, right and left.
//A value of cell 1 means Source.
//A value of cell 2 means Destination.
//A value of cell 3 means Blank cell.
//A value of cell 0 means Blank Wall.
//Note: there is only single source and single destination.
import java.util.Scanner;

public class Find_Whether_Path_Exist {
    static int dx[]={0,0,1,-1};
    static int dy[]={1,-1,0,0};
    public static boolean check(int A[][],int x,int y,int n,boolean visited[][]){
        if(x<0 || y<0 || x>=n || y>=n || A[x][y]==0){
            return false;
        }
        visited[x][y]=true;
        if(A[x][y]==2){
            return true;
        }
        for(int i=0;i<4;i++){
            int X=x+dx[i];
            int Y=y+dy[i];
            if(X>=0 && X<n && Y>=0 && Y<n && !visited[X][Y]){
                if(check(A,X,Y,n,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int A[][]=new int[n][n];
            int x=-1,y=-1;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    A[i][j]=sc.nextInt();
                    if(A[i][j]==1){
                        x=i;
                        y=j;
                    }
                }
            }
            boolean visited[][]=new boolean[n][n];
            if(check(A,x,y,n,visited)){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }
}
