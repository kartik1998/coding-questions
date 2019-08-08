package Dynamic_Programming;

import java.util.Scanner;

public class MatrixChainMultiplication {
    public static int MCM(int p[],int i,int j,Integer dp[][]){
        if(i==j){
            return dp[i][j]=0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int sub_res=MCM(p,i,k,dp)+MCM(p,k+1,j,dp)+p[i-1]*p[k]*p[j];
            ans=Math.min(ans,sub_res);
        }
        return dp[i][j]=ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int p[]=new int[n];
            for(int i=0;i<n;i++){
                p[i]=sc.nextInt();
            }
            Integer dp[][]=new Integer[n+1][n+1];
            System.out.println(MCM(p,1,n-1,dp));
        }
    }
}
