package Dynamic_Programming;

import java.util.Scanner;

public class Diwali_Bitmasks_hacker_blocks {
    static int mod=(int)(1e6+3);
    public static int helper(int prev,int in,int k,int count,int n,Integer dp[][][]){
        if(count>k){
            return 0;
        }
        if(in==n){
            if(count==k){
                return dp[prev][in][count]=1;
            }
            return dp[prev][in][count]=0;
        }
        if(dp[prev][in][count]!=null){
            return dp[prev][in][count];
        }
        if(prev==1){
            return dp[prev][in][count]=helper(1,in+1,k,count+1,n,dp)+helper(0,in+1,k,count,n,dp);
        }else{
            return dp[prev][in][count]=helper(1,in+1,k,count,n,dp)+helper(0,in+1,k,count,n,dp);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            Integer dp[][][]=new Integer[2][n+1][k+1];
            System.out.println(helper(0,1,k,0,n,dp)+helper(1,1,k,0,n,dp)%mod);
        }
    }
}
