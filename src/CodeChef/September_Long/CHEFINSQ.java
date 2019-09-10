package CodeChef.September_Long;

import java.util.Scanner;

public class CHEFINSQ {
    public static long minSub(int A[],int N,int K,Long dp[][]){
        if(K==0){
            return dp[N][K]=0L;
        }
        if(N==0){
            return dp[N][K]=(long)Integer.MAX_VALUE;
        }
        if(dp[N][K]!=null){
            return dp[N][K];
        }
        return dp[N][K]=Math.min(minSub(A,N-1,K-1,dp)+A[N-1],minSub(A,N-1,K,dp));
    }// Question yet to complete
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int K=sc.nextInt();
            int A[]=new int[N];
            for(int i=0;i<N;i++){
                A[i]=sc.nextInt();
            }
            Long dp[][]=new Long[N+1][K+1];
            long target=minSub(A,N,K,dp);
        }
    }
}
