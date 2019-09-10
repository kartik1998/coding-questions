package Dynamic_Programming;

import java.util.Scanner;

public class letter_Writer {
    public static long helper(int N,Long dp[]){
        if(N==0){
            return 0;
        }
        if(N<0){
            return Integer.MAX_VALUE;
        }
        if(dp[N]!=null){
            return dp[N];
        }
        return dp[N]=Math.min(helper(N-10,dp),helper(N-12,dp))+1;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            Long dp[]=new Long[N+1];
            long x=helper(N,dp);
            if(x>=Integer.MAX_VALUE){
                System.out.println(-1);
                continue;
            }
            System.out.println(x);
        }
    }
}
