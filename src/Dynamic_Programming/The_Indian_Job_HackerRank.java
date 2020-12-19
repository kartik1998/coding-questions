package Dynamic_Programming;

import java.util.*;

public class The_Indian_Job_HackerRank {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int N = sc.nextInt();
      int G = sc.nextInt();
      PriorityQueue<Integer> q = new PriorityQueue<>(
        Collections.reverseOrder()
      );
      while (N-- > 0) {
        q.add(sc.nextInt());
      }
      while (!q.isEmpty()) {
        int x = -1, y = -1;
        x = q.remove();
        if (!q.isEmpty()) {
          y = q.remove();
        }
        if (y == -1) {
          G -= x;
          break;
        }
        int X = x - y;
        G -= y;
        if (X > 0) {
          q.add(X);
        }
      }
      if (G >= 0) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }
}
