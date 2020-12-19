package CodeChef;

import java.util.Scanner;

public class EOEO {

  public static int phi(int num) {
    int res = num;
    for (int prime = 2; prime * prime <= num; ++prime) {
      if (num % prime == 0) {
        while (num % prime == 0) {
          res = res - (res / prime);
          num = num / prime;
        }
      }
    }
    if (num > 1) {
      res = res - (res / num);
    }
    return res;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int TS = sc.nextInt();
      if (TS % 2 != 0) {
        System.out.println(TS / 2);
      } else {
        System.out.println(phi(TS) / 2);
      }
    }
  }
}
