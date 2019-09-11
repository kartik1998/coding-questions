package Dynamic_Programming;

import java.util.Scanner;

public class Minimum_Number_Of_Deletions {
    public static boolean check(String s,int l,int r){
        for(int i=l,j=r;i<j;i++,j--){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;
    }
    public static int helper(String s,int l,int r,Integer dp[][]){
        if(check(s,l,r)){
            return dp[l][r]=0;
        }
        if(dp[l][r]!=null){
            return dp[l][r];
        }
        if(s.charAt(l)==s.charAt(r)){
            return dp[l][r]=helper(s,l+1,r-1,dp);
        }else{
            return dp[l][r]=Math.min(helper(s,l+1,r,dp),helper(s,l,r-1,dp))+1;
        }
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            String s=sc.next();
            Integer dp[][]=new Integer[n+1][n+1];
            System.out.println(helper(s,0,n-1,dp));
        }
    }
}
