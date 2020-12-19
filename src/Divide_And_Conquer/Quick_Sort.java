package Divide_And_Conquer;

import java.util.Scanner;

public class Quick_Sort {

  public static int partition(int A[], int s, int e) {
    int index = s;
    for (int i = s + 1; i <= e; i++) {
      if (A[i] < A[index]) {
        int temp = A[i];
        A[i] = A[index];
        A[index] = temp;
        i = index + 1;
      }
    }
    return index;
  }

  public static void QuickSort(int A[], int s, int e) {
    if (s > e) {
      return;
    }
    int ind = partition(A, s, e);
    QuickSort(A, s, ind - 1);
    QuickSort(A, ind + 1, e);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int A[] = new int[n];
    for (int i = 0; i < n; i++) {
      A[i] = sc.nextInt();
    }
    QuickSort(A, 0, n - 1);
    for (int i : A) {
      System.out.print(i + " ");
    }
  }
}
