package Dynamic_Programming;

import java.util.Scanner;

public class Unbounded_Knapsack {
    public static int knapsack(int val[],int wt[],int W,int n,Integer dp[][]){
        if(W<0){
            return Integer.MIN_VALUE;
        }
        if(W==0 || n==0){
            return dp[n][W]=0;
        }
        if(dp[n][W]!=null){
            return dp[n][W];
        }
        return dp[n][W]=Math.max(knapsack(val,wt,W-wt[n-1],n,dp)+val[n-1],knapsack(val,wt,W,n-1,dp));
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int W=sc.nextInt();
            int val[]=new int[n];
            int wt[]=new int[n];
            for(int i=0;i<n;i++){
                val[i]=sc.nextInt();
            }
            for(int i=0;i<n;i++){
                wt[i]=sc.nextInt();
            }
            Integer dp[][]=new Integer[n+1][W+1];
            System.out.println(knapsack(val,wt,W,n,dp));

        }
    }
}
