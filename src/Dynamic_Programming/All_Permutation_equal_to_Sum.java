package Dynamic_Programming;

import java.util.Scanner;

public class All_Permutation_equal_to_Sum {

  public static int helper(int sum, int A[], int in) {
    if (sum == 0) {
      return 1;
    }
    if (sum < 0 || in >= A.length) {
      return 0;
    }
    int ans = 0;
    for (int i = in; i < A.length; i++) {
      ans += helper(sum - A[i], A, i);
    }
    return ans;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int A[] = new int[n];
      for (int i = 0; i < n; i++) {
        A[i] = sc.nextInt();
      }
      int sum = sc.nextInt();
      System.out.println(helper(sum, A, 0));
    }
  }
}
