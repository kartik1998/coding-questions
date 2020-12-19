package Dynamic_Programming;

import java.util.Scanner;

// Can be solved in O(n) using Kadanes algorithm
public class Maximum_difference_of_zeros_and_ones_in_binary_string {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      String s = sc.next();
      int A[] = new int[s.length()];
      for (int i = 0; i < A.length; i++) {
        if (s.charAt(i) == '1') {
          A[i] = -1;
        } else {
          A[i] = 1;
        }
      }
      int curr = 0;
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < A.length; i++) {
        curr += A[i];
        max = Math.max(max, curr);
        curr = Math.max(0, curr);
      }
      System.out.println(max);
    }
  }
}
