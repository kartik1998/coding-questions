package Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

public class Temple_Offerings {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int A[] = new int[n];
      for (int i = 0; i < n; i++) {
        A[i] = sc.nextInt();
      }
      int left[] = new int[n];
      Arrays.fill(left, 1);
      for (int i = 1; i < n; i++) {
        if (A[i] > A[i - 1]) {
          left[i] = left[i - 1] + 1;
        }
      }
      for (int i = n - 2; i >= 0; i--) {
        if (A[i] > A[i + 1]) {
          left[i] = Math.max(left[i], left[i + 1] + 1);
        }
      }
      int sum = 0;
      for (int i : left) {
        sum += i;
      }
      System.out.println(sum);
    }
  }
}
