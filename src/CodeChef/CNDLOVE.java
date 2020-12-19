package CodeChef;

import java.util.Scanner;

public class CNDLOVE {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int N = sc.nextInt();
      int sum = 0;
      for (int i = 0; i < N; i++) {
        sum += sc.nextInt();
      }
      if (sum % 2 != 0) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }
}
