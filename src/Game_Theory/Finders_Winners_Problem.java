package Game_Theory;

import java.util.Scanner;

// Given n coins for two players playing a game. Each player can pick 1 or two coins. The last player to pick coins wins.
// Tell which player wins : A or B (A moves first)
public class Finders_Winners_Problem {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      if (n % 3 == 0) {
        System.out.println("B wins");
      } else {
        System.out.println("A wins");
      }
    }
  }
}
