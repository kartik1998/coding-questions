package Dynamic_Programming;

import java.util.Scanner;

public class Sherlock_And_Cost_hackerrank {
    public static int cost(int[] A) {
        int n=A.length;
        int dp[][]=new int[n][2];
        for(int i=n-2;i>=0;i--){
            dp[i][0]=(A[i+1]-1)+dp[i+1][1];
            dp[i][1]=Math.max(Math.abs(A[i+1]-A[i])+dp[i+1][1],Math.abs(A[i]-1)+dp[i+1][0]);
        }
        return Math.max(dp[0][0],dp[0][1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int A[]=new int[n];
            for(int i=0;i<n;i++){
                A[i]=sc.nextInt();
            }
            System.out.println(cost(A));
        }
    }
}
