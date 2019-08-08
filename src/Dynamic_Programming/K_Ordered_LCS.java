package Dynamic_Programming;

import java.io.IOException;
import java.util.Scanner;

public class K_Ordered_LCS {
    public static long k_lcs(long A[],long B[],int n,int m,int k,Long dp[][][]){
        if(n==0 || m==0){
            return dp[n][m][k]=0L;
        }
        if(dp[n][m][k]!=null){
            return dp[n][m][k];
        }
        if(A[n-1]==B[m-1]){
            return dp[n][m][k]=1+k_lcs(A,B,n-1,m-1,k,dp);
        }else{
            long res=0;
            if(k>0){
                res=1+k_lcs(A,B,n-1,m-1,k-1,dp);
            }
            res=Math.max(res,Math.max(k_lcs(A,B,n-1,m,k,dp),k_lcs(A,B,n,m-1,k,dp)));
            return dp[n][m][k]=res;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int k=sc.nextInt();
        long A[]=new long[n];
        long B[]=new long[m];
        for(int i=0;i<n;i++){
            A[i]=sc.nextLong();
        }
        for(int i=0;i<m;i++){
            B[i]=sc.nextLong();
        }
        Long dp[][][]=new Long[n+1][m+1][k+1];
        System.out.println(k_lcs(A,B,n,m,k,dp));

    }
}
