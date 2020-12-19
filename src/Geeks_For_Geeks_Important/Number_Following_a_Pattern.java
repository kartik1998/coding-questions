package Geeks_For_Geeks_Important;

import java.util.Scanner;
import java.util.Stack;

/* https://practice.geeksforgeeks.org/problems/number-following-a-pattern/0 */

public class Number_Following_a_Pattern {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      String str = sc.next();
      Stack<Integer> s = new Stack<>();
      int num = 1;
      s.push(1);
      for (int i = 0; i <= str.length(); i++) {
        num++;
        if (i == str.length() || str.charAt(i) == 'I') {
          while (!s.isEmpty()) {
            System.out.print(s.pop());
          }
        }
        s.push(num);
      }
      System.out.println();
    }
  }
}
