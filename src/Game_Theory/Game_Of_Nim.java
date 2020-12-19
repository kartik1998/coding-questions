package Game_Theory;

import java.util.Scanner;

//Given a number of piles in which each pile contains some numbers of stones/coins.
// In each turn, a player can choose only one pile and remove any number of stones (at least one) from that pile.
// The player who cannot move is considered to lose the game (i.e., one who take the last stone is the winner).
public class Game_Of_Nim {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int A[] = new int[n];
      int xor_sum = 0;
      for (int i = 0; i < n; i++) {
        A[i] = sc.nextInt();
        xor_sum = xor_sum ^ A[i];
      }
      // if the nim_sum (xor_Sum) is non zero then A will definitely lose. Otherwise A wins.
      if (xor_sum == 0) {
        System.out.println("B wins");
      } else {
        System.out.println("A wins");
      }
    }
  }
}
