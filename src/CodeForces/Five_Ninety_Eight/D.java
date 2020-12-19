package CodeForces.Five_Ninety_Eight;

import java.util.Arrays;
import java.util.Scanner;

public class D {

  public static void swap(char S[], int in1, int in2) {
    char temp = S[in1];
    S[in1] = S[in2];
    S[in2] = temp;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt(), k = sc.nextInt();
      char S[] = sc.next().toCharArray();
      for (int i = 0; i < S.length; i++) {
        if (S[i] == '1') {
          for (int j = Math.min(i + k, S.length - 1); j > i; j--) {
            if (S[j] == '0') {
              swap(S, i, j);
              k -= (j - i);
              break;
            }
          }
        }
      }
      for (char i : S) {
        System.out.print(i);
      }
      System.out.println();
    }
  }
}
