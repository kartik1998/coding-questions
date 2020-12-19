package Divide_And_Conquer;

import java.util.Scanner;

public class Maximum_Value_In_A_Bitonic_Subarray {

  public static int search(int A[], int s, int e) {
    if (s > e) {
      return -1;
    } else {
      if (s == e) {
        return A[s];
      } else if (e == s + 1) {
        return Math.max(A[s], A[e]);
      } else if (e == s + 2) {
        return Math.max(A[s], Math.max(A[s + 1], A[e]));
      } else if (A[e] > A[e - 1]) {
        return A[e];
      } else if (A[s] > A[s + 1]) {
        return A[s];
      } else {
        int mid = (s + e) / 2;
        if (A[mid] > A[mid - 1]) {
          if (A[mid] > A[mid + 1]) {
            return A[mid];
          } else {
            return search(A, mid + 1, e);
          }
        } else {
          return search(A, s, mid - 1);
        }
      }
    }
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
      System.out.println(search(A, 0, n - 1));
    }
  }
}
