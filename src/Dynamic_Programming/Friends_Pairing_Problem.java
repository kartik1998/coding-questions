package Dynamic_Programming;

import java.util.Scanner;

public class Friends_Pairing_Problem {
    public static int pairs(int n,Integer dp[]){
        if(n==0 || n==1 || n==2){
            return dp[n]=n;
        }
        if(dp[n]!=null){
            return dp[n];
        }
        return dp[n]=pairs(n-1,dp)+(n-1)*pairs(n-2,dp);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            Integer dp[]=new Integer[n+1];
            System.out.println(pairs(n,dp));
        }
    }
}
