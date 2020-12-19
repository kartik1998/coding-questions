package CodeChef;

import java.util.Scanner;

public class WATCHFB {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      long preA = -1, preB = -1;
      int N = sc.nextInt();
      while (N-- > 0) {
        int x = sc.nextInt();
        long A = sc.nextInt(), B = sc.nextInt();
        if (x == 1) {
          System.out.println("YES");
          preA = A;
          preB = B;
        } else {
          if (preA == -1 || preB == -1) {
            System.out.println("NO");
          } else {
            if (A == B) {
              System.out.println("YES");
              preA = A;
              preB = B;
            } else {
              if (preA >= A || preB >= A || preA >= B || preB >= B) {
                System.out.println("YES");
                if (preA >= A || preB >= B) {
                  preB = A;
                  preA = B;
                } else if (preB >= A || preA >= B) {
                  preB = B;
                  preA = A;
                }
              } else {
                System.out.println("NO");
              }
            }
          }
        }
      }
    }
  }
}
