package Dynamic_Programming;

import java.util.Scanner;

// link : https://practice.geeksforgeeks.org/problems/modify-array-to-maximize-sum-of-adjacent-differences/0
public class Modify_array_to_maximize_sum_of_adjacent_differences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int A[]=new int[n];
            for(int i=0;i<n;i++){
                A[i]=sc.nextInt();
            }
            int dp[][]=new int[2][n];
            for(int i=1;i<n;i++){
                dp[0][i]=dp[1][i-1]+Math.abs(A[i-1]-1);
                dp[1][i]=Math.max(Math.abs(A[i]-1)+dp[0][i-1],Math.abs(A[i]-A[i-1])+dp[1][i-1]);
            }
            System.out.println(Math.max(dp[0][n-1],dp[1][n-1]));
        }
    }
}
