package AMCAT;

import java.util.Scanner;

// Given an array and a key. Print a result array with the sum of numbers a window( of value k) behind a number or
// ahead of the number. behind if k<0 else ahead.
public class Sliding_Window_Key {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(), k = sc.nextInt();
    int A[] = new int[n];
    for (int i = 0; i < n; i++) {
      A[i] = sc.nextInt();
    }
    int res[] = new int[n];
    if (k < 0) {
      k = Math.abs(k);
      int in = n - k, ind = n - k, sum = 0;
      while (in < n) {
        sum += A[in];
        in++;
      }
      for (int i = 0; i < n; i++) {
        res[i] = sum;
        if (ind < n) {
          sum -= A[ind];
          sum += A[i];
          ind++;
        } else {
          sum -= A[i - k];
          sum += A[i];
        }
      }
      for (int i : res) {
        System.out.print(i + " ");
      }
    } else {
      int in = k - 1, ind = k - 1, sum = 0;
      while (in >= 0) {
        sum += A[in];
        in--;
      }
      for (int i = n - 1; i >= 0; i--) {
        res[i] = sum;
        if (ind >= 0) {
          sum -= A[ind];
          sum += A[i];
          ind--;
        } else {
          sum -= A[i + k];
          sum += A[i];
        }
      }
      for (int i : res) {
        System.out.print(i + " ");
      }
    }
  }
}
