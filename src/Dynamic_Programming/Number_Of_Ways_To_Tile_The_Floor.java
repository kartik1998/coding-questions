package Dynamic_Programming;

import java.util.Scanner;

public class Number_Of_Ways_To_Tile_The_Floor {
    public static int helper(int n,int m,Integer dp[]){
        if(n==0 || m==0){
            return dp[n]=1;
        }
        if(n<0 || m<0){
            return 0;
        }
        if(dp[n]!=null){
            return dp[n];
        }
        return dp[n]=helper(n-1,m,dp)+helper(n-m,m,dp);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            Integer dp[]=new Integer[n+1];
            System.out.println(helper(n,m,dp));
        }
    }
}
