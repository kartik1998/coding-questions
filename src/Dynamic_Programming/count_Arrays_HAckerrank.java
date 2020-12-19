package Dynamic_Programming;

import java.util.Scanner;

public class count_Arrays_HAckerrank {

  public static long countArray(int n, int k, int x) {
    long mod = (long) (1e9 + 7);
    return helper(n, k, 1, 2, x) % mod;
  }

  public static long helper(int n, int k, int prev, int in, int x) {
    if (in == n) {
      return 1;
    }
    long count = 0;
    for (int i = 1; i <= k; i++) {
      if (in == n - 1 && i == x || i == prev) {
        continue;
      }
      count += helper(n, k, i, in + 1, x);
    }
    return count;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(), k = sc.nextInt(), x = sc.nextInt();
    System.out.println(countArray(n, k, x));
  }
}
