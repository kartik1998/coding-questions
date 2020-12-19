package LeetCode;

import java.util.HashSet;
import java.util.Scanner;

// https://leetcode.com/problems/fraction-to-recurring-decimal/
public class Fraction_to_recurring_decimal {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int N = sc.nextInt(), D = sc.nextInt();
      String res = String.valueOf(N / D);
      int rem = N % D;
      HashSet<String> set = new HashSet<>();
      String sub = "";
      while (rem != 0) {
        rem *= 10;
        if (rem < D) {
          sub += "0";
        } else {
          String s = String.valueOf(rem / D);
          sub += s;
        }
      }
      if (sub.equals("")) {
        System.out.println(res);
      } else {
        System.out.println(res + "." + sub);
      }
    }
  }
}
