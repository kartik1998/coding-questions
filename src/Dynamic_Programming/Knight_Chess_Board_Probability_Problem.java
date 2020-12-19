package Dynamic_Programming;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Knight_Chess_Board_Probability_Problem {

  static int dx[] = { 2, -2, 2, -2, 1, -1, 1, -1 };
  static int dy[] = { 1, -1, -1, 1, 2, -2, -2, 2 };
  static Double memo[][][] = new Double[100][100][100];

  public static double knightProbability(int N, int K, int r, int c) {
    return helper(N, K, r, c);
  }

  public static boolean isSafe(int x, int y, int n) {
    if (x >= 0 && x < n && y >= 0 && y < n) {
      return true;
    }
    return false;
  }

  public static double helper(int N, int K, int r, int c) {
    if (memo[r][c][K] != null) {
      return memo[r][c][K];
    }
    if (K == 0) {
      memo[r][c][K] = 1.0;
      return 1.0;
    }
    double probs = 0;
    for (int i = 0; i < 8; i++) {
      int x = r + dx[i];
      int y = c + dy[i];
      if (isSafe(x, y, N)) {
        probs += helper(N, K - 1, x, y) / 8;
      }
    }
    return memo[r][c][K] = probs;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int N = sc.nextInt();
      int K = sc.nextInt();
      int r = sc.nextInt();
      int c = sc.nextInt();
      double x = knightProbability(N, K, r, c);
      DecimalFormat df = new DecimalFormat("#.########");
      String ans = df.format(x);
      System.out.println(ans);
    }
  }
}
