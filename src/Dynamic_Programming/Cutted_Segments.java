package Dynamic_Programming;

import java.util.Scanner;

public class Cutted_Segments {
    public static long helper(int N,int X,int Y,int Z,Long dp[]){
        if(N==0){
            return dp[N]=0L;
        }
        if(N<0){
            return Integer.MIN_VALUE;
        }
        if(dp[N]!=null){
            return dp[N];
        }
        long a=helper(N-X,X,Y,Z,dp);
        long b=helper(N-Y,X,Y,Z,dp);
        long c=helper(N-Z,X,Y,Z,dp);
        return dp[N]=Math.max(a,Math.max(b,c))+1;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int X=sc.nextInt();
            int Y=sc.nextInt();
            int Z=sc.nextInt();
            Long dp[]=new Long[N+1];
            System.out.println(helper(N,X,Y,Z,dp));
        }
    }
}
