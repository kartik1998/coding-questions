package Dynamic_Programming;

import java.util.Scanner;

public class Maximum_1s_Square {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int A[][]=new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++) {
                    A[i][j] = sc.nextInt();
                }
            }
            int dp[][]=new int[n][m];
            int max=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(i==0 || j==0){
                        dp[i][j]=A[i][j];
                    }else{
                        if(A[i][j]==1) {
                            dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                        }else{
                            dp[i][j]=0;
                        }
                    }
                    max=Math.max(max,dp[i][j]);
                }
            }
            System.out.println(max);
        }
    }
}
