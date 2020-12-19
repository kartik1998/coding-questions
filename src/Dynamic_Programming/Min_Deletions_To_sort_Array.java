package Dynamic_Programming;

import java.util.Scanner;

// Array length - LIS length
public class Min_Deletions_To_sort_Array {

  public static int lis(int arr[]) {
    int dp[] = new int[arr.length];
    dp[0] = 1;
    int max = 0;
    for (int i = 1; i < arr.length; i++) {
      dp[i] = 1;
      for (int j = i - 1; j >= 0; j--) {
        if (arr[j] <= arr[i]) {
          dp[i] = Math.max(dp[j] + 1, dp[i]);
        }
      }
      max = Math.max(max, dp[i]);
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
      System.out.println(n - lis(arr));
    }
  }
}
