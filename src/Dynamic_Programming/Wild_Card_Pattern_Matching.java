package Dynamic_Programming;

import java.util.Scanner;

public class Wild_Card_Pattern_Matching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String a=sc.next();
            String b=sc.next();
            int n=a.length();
            int m=b.length();
            Boolean dp[][]=new Boolean[n+1][m+1];
            System.out.println(helper(a,b,n,m,dp));
        }
    }
    public static boolean helper(String a,String b,int n,int m,Boolean dp[][]){
        if(n==0){
            if(m==0 || b.charAt(m-1)=='*' && helper(a,b,n,m-1,dp)){
                return dp[n][m]=true;
            }
            return dp[n][m]=false;
        }
        if(m==0){
            return dp[n][m]=false;
        }
        if(dp[n][m]!=null){
            return dp[n][m];
        }
        if(a.charAt(n-1)==b.charAt(m-1) || b.charAt(m-1)=='?'){
            return dp[n][m]=helper(a,b,n-1,m-1,dp);
        }else if(b.charAt(m-1)=='*'){
            return dp[n][m]=helper(a,b,n-1,m,dp) || helper(a,b,n,m-1,dp);
        }else{
            return dp[n][m]=false;
        }
    }
}
