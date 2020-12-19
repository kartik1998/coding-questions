package Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

public class min_Jumps_Array {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int A[] = new int[n];
      for (int i = 0; i < n; i++) {
        A[i] = sc.nextInt();
      }
      int dp[] = new int[n];
      Arrays.fill(dp, Integer.MAX_VALUE);
      dp[n - 1] = 0;
      for (int i = n - 2; i >= 0; i--) {
        for (int j = i + 1; j <= A[i] + i; j++) {
          if (j >= n) {
            break;
          }
          if (dp[j] != Integer.MAX_VALUE && dp[i] > dp[j] + 1) {
            dp[i] = dp[j] + 1;
          }
        }
      }
      if (dp[0] == Integer.MAX_VALUE) {
        System.out.println("-1");
      } else {
        System.out.println(dp[0]);
      }
    }
  }
}
