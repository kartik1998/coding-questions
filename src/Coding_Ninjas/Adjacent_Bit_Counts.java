package Coding_Ninjas;

import java.math.BigInteger;
import java.util.Scanner;

public class Adjacent_Bit_Counts {

  public static BigInteger helper(
    int n,
    int k,
    int count,
    int prev,
    BigInteger dp[][][]
  ) {
    if (count > k) {
      return new BigInteger("0");
    }
    if (n == 0 && count == k) {
      return dp[n][count][prev] = new BigInteger("1");
    }
    if (n == 0) {
      return dp[n][count][prev] = new BigInteger("0");
    }
    if (dp[n][count][prev] != null) {
      return dp[n][count][prev];
    }
    if (prev == 1) {
      return (
        dp[n][count][prev] =
          helper(n - 1, k, count + 1, 1, dp).add(helper(n - 1, k, count, 0, dp))
      );
    } else {
      return (
        dp[n][count][prev] =
          helper(n - 1, k, count, 1, dp).add(helper(n - 1, k, count, 0, dp))
      );
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int c = sc.nextInt();
      int n = sc.nextInt();
      int k = sc.nextInt();
      BigInteger mod = new BigInteger("1000000007");
      BigInteger dp[][][] = new BigInteger[n + 1][k + 1][2];
      BigInteger ans = helper(n - 1, k, 0, 0, dp)
        .add(helper(n - 1, k, 0, 1, dp));
      System.out.println(c + " " + ans.mod(mod));
    }
  }
}
