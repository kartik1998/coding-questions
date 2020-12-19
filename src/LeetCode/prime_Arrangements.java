package LeetCode;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class prime_Arrangements {

  static String mod = "1000000007";

  static class Solution {

    public long numPrimeArrangements(int n) {
      boolean sieve[] = new boolean[n + 1];
      Arrays.fill(sieve, true);
      sieve[0] = sieve[1] = false;
      int prime = 0;
      for (int i = 2; i <= n; i++) {
        if (sieve[i]) {
          for (int j = i * i; j <= n; j += i) {
            sieve[j] = false;
          }
          prime++;
        }
      }
      BigInteger fact[] = new BigInteger[n + 1];
      fact[0] = fact[1] = new BigInteger("1");
      for (int i = 2; i <= n; i++) {
        fact[i] = fact[i - 1].multiply(BigInteger.valueOf(i));
      }
      int non_prime = n - prime;
      BigInteger a = fact[prime];
      BigInteger b = fact[non_prime];
      //return (int)(((fact[prime])%mod*(fact[non_prime])%mod)%mod);
      BigInteger mul = a.multiply(b);
      return Integer.parseInt(String.valueOf(mul.mod(new BigInteger(mod))));
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      Solution ob = new Solution();
      System.out.println(ob.numPrimeArrangements(n));
    }
  }
}
