package Dynamic_Programming;

import java.util.*;
public class Exchanging_Coins_Problem {
    public static int helper(int n,Integer dp[]){
        if(n==0){
            return dp[n]=0;
        }
        if(dp[n]!=null){
            return dp[n];
        }
        return dp[n]=Math.max(n,helper(n/2,dp)+helper(n/3,dp)+helper(n/4,dp));
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n=0;
            if(sc.hasNext()){
                n=sc.nextInt();
            }
            Integer dp[]=new Integer[n+1];
            System.out.println(helper(n,dp));

    }
}