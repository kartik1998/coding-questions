package Dynamic_Programming;

import java.util.Scanner;

public class MIn_Partitions {
    public static int helper(int n,int A[],int calc,int sum,Integer dp[][]){
        if(n==0){
            return dp[n][calc]=Math.abs((sum-calc)-calc);
        }
        if(dp[n][sum]!=null){
            return dp[n][calc];
        }
        return dp[n][calc]=Math.min(helper(n-1,A,calc+A[n-1],sum,dp),helper(n-1,A,calc,sum,dp));
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int A[]=new int[n];
            int sum=0;
            for(int i=0;i<n;i++){
                A[i]=sc.nextInt();
                sum+=A[i];
            }
            Integer dp[][]=new Integer[n+1][sum+1];
            System.out.println(helper(n,A,0,sum,dp));

        }
    }
}
