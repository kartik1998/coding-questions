package CodeChef;

import java.util.Scanner;

public class S10E {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt(), count = 0;
      int A[] = new int[n];
      for (int i = 0; i < n; i++) {
        A[i] = sc.nextInt();
        boolean flag = true;
        for (int j = i - 1; j >= 0 && j >= i - 5; j--) {
          if (A[i] >= A[j]) {
            flag = false;
            break;
          }
        }
        if (flag) {
          count++;
        }
      }
      System.out.println(count);
    }
  }
}
