package Google_KickStart;

import java.util.Scanner;

public class Wiggle_Walk {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    int index = 1;
    while (T-- > 0) {
      int N = sc.nextInt(), n = sc.nextInt(), m = sc.nextInt(), x =
        sc.nextInt() - 1, y = sc.nextInt() - 1;
      boolean vis[][] = new boolean[n][m];
      vis[x][y] = true;
      String S = sc.next();
      for (int i = 0; i < S.length(); i++) {
        char ch = S.charAt(i);
        if (ch == 'N') {
          x--;
          while (vis[x][y]) {
            x--;
          }
          vis[x][y] = true;
        } else if (ch == 'E') {
          y++;
          while (vis[x][y]) {
            y++;
          }
          vis[x][y] = true;
        } else if (ch == 'W') {
          y--;
          while (vis[x][y]) {
            y--;
          }
          vis[x][y] = true;
        } else {
          x++;
          while (vis[x][y]) {
            x++;
          }
          vis[x][y] = true;
        }
      }
      x++;
      y++;
      System.out.println("Case #" + index + ": " + x + " " + y);
      index++;
    }
  }
}
