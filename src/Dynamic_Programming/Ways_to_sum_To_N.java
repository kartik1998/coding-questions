package Dynamic_Programming;

import java.math.BigInteger;
import java.util.Scanner;

public class Ways_to_sum_To_N {

  static BigInteger mod = new BigInteger("1000000007");

  public static BigInteger helper(int A[], int n, int k, BigInteger dp[]) {
    if (n == 0) {
      return dp[k] = new BigInteger("0");
    }
    if (k == 0) {
      return dp[k] = new BigInteger("1");
    }
    if (dp[k] != null) {
      return dp[k];
    }
    BigInteger count = new BigInteger("0");
    for (int i = 0; i < n; i++) {
      BigInteger sub = new BigInteger("0");
      if (k >= A[i] && A[i] != 0) {
        sub = helper(A, n, k - A[i], dp);
      }
      count = count.add(sub);
    }
    return dp[k] = count;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int A[] = new int[n];
      for (int i = 0; i < n; i++) {
        A[i] = sc.nextInt();
      }
      BigInteger dp[] = new BigInteger[k + 1];
      System.out.println(helper(A, n, k, dp).mod(mod));
    }
  }
}
