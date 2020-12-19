package Dynamic_Programming;

import java.util.Scanner;

public class Max_Sum_Increasing_Subsequence {

  public static int helper(int arr[], int n) {
    int dp[] = new int[n];
    dp[0] = arr[0];
    for (int i = 1; i < n; i++) {
      dp[i] = arr[i];
      for (int j = i - 1; j >= 0; j--) {
        if (arr[j] < arr[i]) {
          int possibleAns = dp[j] + arr[i];
          if (possibleAns > dp[i]) {
            dp[i] = possibleAns;
          }
        }
      }
    }
    int max = -1;
    for (int i = 0; i < dp.length; i++) {
      if (max < dp[i]) {
        max = dp[i];
      }
    }
    return max;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int arr[] = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(helper(arr, n));
    }
  }
}
