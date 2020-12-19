package Stacks_And_Queues;

import java.util.Scanner;

public class Print_Binary_Number {

  public static void print(int n) {
    if (n == 0) {
      System.out.print(0);
      return;
    }
    print(n / 2);
    System.out.print(n % 2);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      print(n);
    }
  }
}
