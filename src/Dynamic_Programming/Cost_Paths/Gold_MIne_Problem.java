package Dynamic_Programming.Cost_Paths;

import java.util.Scanner;

public class Gold_MIne_Problem {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int A[][]=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    A[i][j]=sc.nextInt();
                }
            }
            int dp[][]=new int[n][n];
            int ans=0;
            for(int j=0;j<n;j++){
                for(int i=0;i<n;i++) {
                    if (j == 0) {
                        dp[i][j] = A[i][j];
                    } else {
                        int max = -1;
                        int Y = j - 1;
                        int X1 = i - 1;
                        int X2 = i;
                        int X3 = i + 1;
                        if (X1 >= 0) {
                            max = Math.max(max, dp[X1][Y]);
                        }
                        if (X3 < n) {
                            max = Math.max(max, dp[X3][Y]);
                        }
                        max = Math.max(max, dp[X2][Y]);
                        dp[i][j] = max + A[i][j];
                    }
                    if (j == n - 1) {
                        ans = Math.max(ans, dp[i][j]);
                    }
                }
            }
            for(int i[]:dp){
                for(int j:i){
                    System.out.print(j+" ");
                }
                System.out.println();
            }
            System.out.println(ans);
        }
    }
}
