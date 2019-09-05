package HackerEarth;

import java.util.Scanner;

public class Maximum_Profit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long x = sc.nextLong();
        long A[] = new long[n];
        long B[] = new long[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            B[i] = sc.nextInt();
        }
        long dp[][] = new long[2][n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[0][i] = A[i];
                dp[1][i] = B[i];
            } else {
                dp[0][i] = Math.max(dp[0][i - 1] + A[i], dp[1][i - 1] + A[i] - x);
                dp[1][i] = Math.max(dp[1][i - 1] + B[i], dp[0][i - 1] + B[i] - x);
            }
        }
        System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));
    }
}
