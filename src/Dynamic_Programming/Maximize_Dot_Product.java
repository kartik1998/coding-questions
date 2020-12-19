package Dynamic_Programming;

import java.math.BigInteger;
import java.util.Scanner;

// Given a array A with N elements and array B with M elements. You have to insert (N-M) zeroes in between
// array B such that the dot product of array A and array B is maximum.
//Definition of Dot Product : A.B = A[0]*B[0] + A[1]*B[1]+....A[N]*B[N].
public class Maximize_Dot_Product {

  public static BigInteger max(BigInteger a, BigInteger b) {
    if (a.compareTo(b) > 0) {
      return a;
    }
    return b;
  }

  public static BigInteger helper(
    int A[],
    int B[],
    int n,
    int m,
    BigInteger dp[][]
  ) {
    if (n == 0 || m == 0) {
      return dp[n][m] = new BigInteger("0");
    }
    if (dp[n][m] != null) {
      return dp[n][m];
    }
    return (
      dp[n][m] =
        max(
          helper(A, B, n - 1, m, dp),
          helper(A, B, n - 1, m - 1, dp)
            .add(BigInteger.valueOf(A[n - 1] * B[m - 1]))
        )
    );
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int A[] = new int[n];
      int B[] = new int[m];
      for (int i = 0; i < n; i++) {
        A[i] = sc.nextInt();
      }
      for (int i = 0; i < m; i++) {
        B[i] = sc.nextInt();
      }
      BigInteger dp[][] = new BigInteger[n + 1][m + 1];
      System.out.println(helper(A, B, n, m, dp));
    }
  }
}
