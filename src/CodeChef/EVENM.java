package CodeChef;

import java.util.Scanner;

public class EVENM {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int k = 1;
      boolean flag = true;
      int A[][] = new int[n][n];
      for (int i = 0; i < n; i++) {
        if (flag) {
          for (int j = 0; j < n; j++) {
            A[i][j] = k++;
          }
        } else {
          for (int j = n - 1; j >= 0; j--) {
            A[i][j] = k++;
          }
        }
        flag = !flag;
      }
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          System.out.print(A[i][j] + " ");
        }
        System.out.println();
      }
    }
  }
}
