package HackerEarth;

import java.util.Scanner;

public class Intelligent_Girl_DP {

  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    char s[] = sc.next().toCharArray();
    int dp[] = new int[s.length];
    if ((s[s.length - 1] - '0') % 2 == 0) {
      dp[s.length - 1] = 1;
    } else {
      dp[s.length - 1] = 0;
    }
    for (int i = s.length - 2; i >= 0; i--) {
      if ((s[i] - '0') % 2 == 0) {
        dp[i] = dp[i + 1] + 1;
      } else {
        dp[i] = dp[i + 1];
      }
    }
    for (int i = 0; i < dp.length; i++) {
      System.out.print(dp[i] + " ");
    }
    System.out.println();
  }
}
