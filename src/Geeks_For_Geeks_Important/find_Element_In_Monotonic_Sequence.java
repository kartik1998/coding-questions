package Geeks_For_Geeks_Important;

import java.math.BigInteger;
import java.util.Scanner;

// Given an integer k and a monotonic increasing sequence:
//f(n) = an + bn [log2(n)] + cn^3 where (a = 1, 2, 3, …), (b = 1, 2, 3, …), (c = 0, 1, 2, 3, …)
//Here, [log2(n)] means, taking the log to the base 2 and round the value down Thus,
public class find_Element_In_Monotonic_Sequence {

  public static long func(int a, int b, int c, long n) {
    long res = 0;
    res += a * n;
    res += b * n * (Math.floor(Math.log(n) / Math.log(2)));
    res += c * (n * n * n);
    return res;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
      long k = sc.nextLong();
      long s = 1;
      long e = 1000000;
      if (c == 0) {
        e = 100000000000000000L;
      }
      long ans = -1;
      while (s <= e) {
        long mid = (s + e) / 2;
        long x = func(a, b, c, mid);
        if (x == k) {
          ans = mid;
          break;
        } else if (x > k) {
          e = mid - 1;
        } else {
          s = mid + 1;
        }
      }
      System.out.println(ans);
    }
  }
}
