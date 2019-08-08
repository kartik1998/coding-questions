package Dynamic_Programming;

import java.util.Scanner;

public class Optimal_Game_Strategy {
    public static int optimal(int A[],int s,int e,Integer dp[][]){
        if(s==e){
            return dp[s][e]=A[s];
        }
        if(e==s+1){
            return dp[s][e]=Math.max(A[s],A[e]);
        }
        if(dp[s][e]!=null){
            return dp[s][e];
        }
        int a=A[s]+Math.min(optimal(A,s+1,e-1,dp),optimal(A,s+2,e,dp));
        int b=A[e]+Math.min(optimal(A,s+1,e-1,dp),optimal(A,s,e-2,dp));
        return dp[s][e]=Math.max(a,b);
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
            System.out.println(optimal(A,0,n-1,dp));
        }
    }
}
