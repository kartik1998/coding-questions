package Dynamic_Programming;

import java.util.Scanner;

public class Max_sum_subarray_by_removing_at_most_one_element {

  public static int maxSumSubarray(int A[], int n) {
    int left[] = new int[n];
    int right[] = new int[n];
    left[0] = A[0];
    right[n - 1] = A[n - 1];
    for (int i = 1; i < n; i++) {
      left[i] = Math.max(left[i - 1] + A[i], A[i]);
    }
    for (int i = n - 2; i >= 0; i--) {
      right[i] = Math.max(right[i + 1] + A[i], A[i]);
    }
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      if (i == 0) {
        max = Math.max(max, Math.max(right[i + 1] + A[i], right[i + 1]));
      } else if (i == n - 1) {
        max = Math.max(max, Math.max(left[i - 1] + A[i], left[i - 1]));
      } else {
        max =
          Math.max(
            max,
            Math.max(
              left[i - 1] + right[i + 1] + A[i],
              left[i - 1] + right[i + 1]
            )
          );
      }
      max = Math.max(max, A[i]);
    }
    return max;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int A[] = new int[n];
    for (int i = 0; i < n; i++) {
      A[i] = sc.nextInt();
    }
    System.out.println(maxSumSubarray(A, n));
  }
}
