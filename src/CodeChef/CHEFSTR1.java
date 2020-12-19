package CodeChef;

import java.util.Scanner;

public class CHEFSTR1 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int A[] = new int[n];
      for (int i = 0; i < n; i++) {
        A[i] = sc.nextInt();
      }
      int res = 0;
      for (int i = 1; i < n; i++) {
        res += (Math.abs(A[i] - A[i - 1]) - 1);
      }
      System.out.println(res);
    }
  }
}
