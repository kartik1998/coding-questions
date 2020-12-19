package Google;

import java.util.Scanner;

public class KickStart_Alarm {

  static int MOD = 1000000007;
  static long A[] = new long[1000000];
  static long P[] = new long[1000000];

  public static long power(long N, long e) {
    long ans = 1;

    while (e > 0) {
      if (e % 2 == 1) {
        ans = ans * N % MOD;
      }
      N = N * N % MOD;
      e /= 2;
    }
    return ans;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    int index = 1;
    while (t-- > 0) {
      long N = sc.nextLong(), K = sc.nextLong(), x1 = sc.nextLong(), y1 = sc.nextLong(), C = sc.nextLong();
      long D = sc.nextLong(), E1 = sc.nextLong(), E2 = sc.nextLong(), F = sc.nextLong();
      A[1] = (x1 + y1) % F;
      for (int i = 2; i <= N; i++) {
        long x2 = (C * x1 + D * y1 + E1) % F;
        long y2 = (D * x1 + C * y1 + E2) % F;
        x1 = x2;
        y1 = y2;
        A[i] = (x1 + y1) % F;
      }
      P[1] = K;
      for (int i = 2; i <= N; i++) {
        long curr = power(i, K) + MOD - 1;
        curr = curr * i % MOD * power(i - 1, MOD - 2) % MOD;
        P[i] = (P[i - 1] + curr) % MOD;
      }
      long ans = 0;
      for (int i = 1; i <= N; i++) {
        ans += A[i] * (N - i + 1) % MOD * P[i] % MOD;
      }
      System.out.println("Case #" + index + ": " + ans % MOD);
      index++;
    }
  }
}
