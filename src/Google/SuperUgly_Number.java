package Google;

import java.util.PriorityQueue;
import java.util.Scanner;

public class SuperUgly_Number {

  public static void superUgly(int primes[], int n) {
    PriorityQueue<Integer> q = new PriorityQueue<>();
    for (int i = 0; i < primes.length; i++) {
      q.add(primes[i]);
    }
    System.out.print(1 + " ");
    n--;
    while (n-- > 0) {
      int top = q.remove();
      System.out.print(top + " ");
      for (int i = 0; i < primes.length; i++) {
        if (!q.contains(primes[i] * top)) {
          q.add(primes[i] * top);
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int primes[] = new int[sc.nextInt()];
    for (int i = 0; i < primes.length; i++) {
      primes[i] = sc.nextInt();
    }
    int n = sc.nextInt();
    superUgly(primes, n);
  }
}
