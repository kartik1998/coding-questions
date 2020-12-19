package AMCAT;

import java.util.Scanner;

public class Smallest_Permutation_Number {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      String num = sc.next();
      int dp[] = new int[10];
      for (int i = 0; i < num.length(); i++) {
        dp[num.charAt(i) - '0']++;
      }
      String res = "";
      for (int i = 1; i < 10; i++) {
        while (dp[i] > 0) {
          res += String.valueOf(i);
          dp[i]--;
        }
      }
      String sub = "";
      while (dp[0] > 0) {
        sub += "0";
        dp[0]--;
      }
      if (res.equals("")) {
        System.out.println("0");
      } else {
        System.out.println(res.charAt(0) + sub + res.substring(1));
      }
    }
  }
}
