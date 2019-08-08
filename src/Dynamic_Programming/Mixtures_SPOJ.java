package Dynamic_Programming;

import java.util.Scanner;

public class Mixtures_SPOJ {
    public static int sum(int A[],int s,int e){
        int sum=0;
        for(int i=s;i<=e;i++){
            sum+=A[i];
            sum%=100;
        }
        return sum;
    }
    public static int helper(int A[],int i,int j,Integer dp[][]){
        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int sub_res=helper(A,i,k,dp)+helper(A,k+1,j,dp)+sum(A,i,k)*sum(A,k+1,j);
            ans=Math.min(ans,sub_res);
        }
        return dp[i][j]=ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int A[]=new int[n];
            for(int i=0;i<n;i++){
                A[i]=sc.nextInt();
            }
            Integer dp[][]=new Integer[n+1][n+1];
            System.out.println(helper(A,0,n-1,dp));
        }

    }
}
