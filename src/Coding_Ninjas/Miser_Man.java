package Coding_Ninjas;

import java.util.Scanner;

public class Miser_Man {
    public static boolean isSafe(int x,int y,int N,int M){
        if(x>=0 && x<N && y>=0 && y<M){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int dx[]={-1,-1,-1};
        int dy[]={-1,0,1};
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        int A[][]=new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                A[i][j]=sc.nextInt();
            }
        }
        int dp[][]=new int[N][M];
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(i==0){
                    dp[i][j]=A[i][j];
                }else{
                    int min=Integer.MAX_VALUE;
                    for(int k=0;k<3;k++){
                        int X=i+dx[k];
                        int Y=j+dy[k];
                        if(isSafe(X,Y,N,M)){
                            min=Math.min(min,dp[X][Y]);
                        }
                    }
                    dp[i][j]=A[i][j]+min;
                }
                if(i==N-1){
                    ans=Math.min(ans,dp[i][j]);
                }
            }
        }
        System.out.println(ans);
    }
}
