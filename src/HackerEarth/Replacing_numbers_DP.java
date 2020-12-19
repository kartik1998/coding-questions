package HackerEarth;

import java.util.Scanner;

public class Replacing_numbers_DP {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long A[] = new long[n];
    for (int i = 0; i < n; i++) {
      A[i] = sc.nextLong();
    }
    long pre[] = new long[n];
    long suf[] = new long[n];
    pre[0] = A[0];
    suf[n - 1] = A[n - 1];
    for (int i = 1; i < n; i++) {
      pre[i] = Math.max(pre[i - 1] + A[i], A[i]);
    }
    for (int i = n - 2; i >= 0; i--) {
      suf[i] = Math.max(suf[i + 1] + A[i], A[i]);
    }
    long max = Long.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      if (i == 0) {
        max = Math.max(max, A[i] * A[i] + suf[i + 1]);
      } else if (i == n - 1) {
        max = Math.max(max, A[i] * A[i] + pre[i - 1]);
      } else {
        max = Math.max(max, A[i] * A[i] + suf[i + 1] + pre[i - 1]);
      }
    }
    System.out.println(max);
  }
}
