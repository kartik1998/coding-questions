package Dynamic_Programming;

import java.util.Scanner;

public class Partition_Of_N_Elements_Into_K_Sets {
    public static int helper(int n,int k,Integer dp[][]){
        if(n==0 || k==0 || k>n){
            return dp[n][k]=0;
        }
        if(k==1 || k==n){
            return dp[n][k]=1;
        }
        if(dp[n][k]!=null){
            return dp[n][k];
        }
        return dp[n][k]=k*helper(n-1,k,dp)+helper(n-1,k-1,dp);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            Integer dp[][]=new Integer[n+1][k+1];
            System.out.println(helper(n,k,dp));
        }
    }
}
