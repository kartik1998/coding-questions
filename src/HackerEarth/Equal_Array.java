package HackerEarth;

import java.util.Scanner;

public class Equal_Array {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int A[] = new int[n];
      int dp[] = new int[n];
      int sum = 0;
      for (int i = 0; i < n; i++) {
        A[i] = sc.nextInt();
        sum += A[i];
        dp[i] = sum;
      }
      int min = Integer.MAX_VALUE;
      for (int i = 0; i < n; i++) {
        int x = sum - 2 * dp[i];
        if (x >= 0 && x < min) {
          min = x;
        }
      }
      if (min == Integer.MAX_VALUE) {
        System.out.println(-1);
      } else {
        System.out.println(min);
      }
    }
  }
}
