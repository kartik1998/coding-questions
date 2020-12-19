package HackerEarth;

import java.util.Scanner;

// Stock selling K transactions
public class MI_vs_CSK_And_Pearls {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(), k = sc.nextInt();
    int A[] = new int[n];
    for (int i = 0; i < n; i++) {
      A[i] = sc.nextInt();
    }
    int min = A[0];
    long max = 0;
    for (int i = 1; i < n; i++) {
      int sub = (A[i] - min) * k;
      max = Math.max(max, sub);
      min = Math.min(min, A[i]);
    }
    System.out.println(max);
  }
}
