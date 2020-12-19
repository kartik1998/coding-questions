package Dynamic_Programming;

import java.util.Scanner;

public class Maximum_Product_Subarray {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int A[] = new int[n];
      for (int i = 0; i < n; i++) {
        A[i] = sc.nextInt();
      }
      long curr_max = A[0], curr_min = A[0], prev_max = A[0], prev_min =
        A[0], ans = A[0];
      for (int i = 1; i < n; i++) {
        curr_max = Math.max(prev_max * A[i], Math.max(A[i], prev_min * A[i]));
        curr_min = Math.min(A[i], Math.min(prev_max * A[i], prev_min * A[i]));
        ans = Math.max(ans, curr_max);
        prev_max = curr_max;
        prev_min = curr_min;
      }
      System.out.println(ans);
    }
  }
}
