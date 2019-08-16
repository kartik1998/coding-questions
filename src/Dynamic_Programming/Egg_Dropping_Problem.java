package Dynamic_Programming;

import java.util.Scanner;

public class Egg_Dropping_Problem {
    public static long helper(int n,int e,Long dp[][]){
        if(n==0 || e==0){
            return dp[e][n]=0L;
        }
        if(e==1){
            return dp[e][n]=(long)n;
        }
        if(n==1){
            return dp[e][n]=1L;
        }
        if(dp[e][n]!=null){
            return dp[e][n];
        }
        long min=Long.MAX_VALUE;
        for(int i=1;i<=n;i++){
            long sub=Math.max(helper(n-i,e,dp),helper(i-1,e-1,dp))+1;
            min=Math.min(sub,min);
        }
        return dp[e][n]=min;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int e=sc.nextInt();
            int n=sc.nextInt();
            Long dp[][]=new Long[e+1][n+1];
            System.out.println(helper(n,e,dp));
        }
    }
}
