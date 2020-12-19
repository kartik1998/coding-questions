package Geeks_For_Geeks_Important;

import java.util.Arrays;
import java.util.Scanner;

public class Next_Permutation {

  public static void swap(int A[], int a, int b) {
    int temp = A[a];
    A[a] = A[b];
    A[b] = temp;
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
      int in = -1;
      for (int i = n - 2; i >= 0; i--) {
        if (A[i] < A[i + 1]) {
          in = i;
          break;
        }
      }
      if (in == -1) {
        Arrays.sort(A);
      } else {
        int min_in = in + 1;
        for (int i = in + 2; i < n; i++) {
          if (A[i] > A[in] && A[i] < A[min_in]) {
            min_in = i;
          }
        }
        swap(A, in, min_in);
        Arrays.sort(A, in + 1, A.length);
      }
      for (int i : A) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }
}
