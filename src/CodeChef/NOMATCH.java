package CodeChef;

import java.util.Arrays;
import java.util.Scanner;

public class NOMATCH {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int A[] = new int[n];
      for (int i = 0; i < n; i++) {
        A[i] = sc.nextInt();
      }
      long sum = 0;
      Arrays.sort(A);
      int i = 0, j = n - 1;
      while (i < j) {
        sum += (Math.abs(A[j] - A[i]));
        i++;
        j--;
      }
      System.out.println(sum);
    }
  }
}
