package Stacks_And_Queues;

import java.util.Scanner;
import java.util.Stack;

public class Infix_To_Postfix {

  public static int Precedence(char ch) {
    if (ch == '+' || ch == '-') {
      return 1;
    } else if (ch == '*' || ch == '/') {
      return 2;
    } else {
      return 3;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      String str = sc.next();
      Stack<Character> s = new Stack<>();
      String res = "";
      for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
          res += ch;
        } else if (ch == '(') {
          s.push(ch);
        } else if (ch == ')') {
          while (s.peek() != '(') {
            res += s.pop();
          }
          s.pop();
        } else {
          if (s.isEmpty() || Precedence(ch) > Precedence(s.peek())) {
            s.push(ch);
          } else {
            while (
              !s.isEmpty() &&
              s.peek() != '(' &&
              Precedence(ch) <= Precedence(s.peek())
            ) {
              res += s.pop();
            }
            s.push(ch);
          }
        }
      }
      while (!s.isEmpty()) {
        res += s.pop();
      }
      System.out.println(res);
    }
  }
}
