package CodeForces;

import java.util.*;

public class Complete_The_Projects {

  static class Pair implements Comparable<Pair> {

    int x, y;

    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo(Pair o) {
      return this.x - o.x;
    }
  }

  public static long helper(List<Pair> neg, int n, int R, Long dp[][]) {
    if (n == 0) {
      return 0;
    }
    Pair p = neg.get(n - 1);
    if (dp[n][R] != null) {
      return dp[n][R];
    }
    if (R >= p.x && R >= p.y) {
      return (
        dp[n][R] =
          Math.max(
            1 + helper(neg, n - 1, R - p.y, dp),
            helper(neg, n - 1, R, dp)
          )
      );
    }
    return dp[n][R] = helper(neg, n - 1, R, dp);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(), R = sc.nextInt();
    List<Pair> pos = new ArrayList<>();
    List<Pair> neg = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      int r = sc.nextInt();
      int p = sc.nextInt();
      if (p < 0) {
        neg.add(new Pair(r, Math.abs(p)));
      } else {
        pos.add(new Pair(r, p));
      }
    }
    int count = 0;
    Collections.sort(pos);
    for (int i = 0; i < pos.size(); i++) {
      Pair p = pos.get(i);
      if (R >= p.x) {
        R += p.y;
        count++;
      } else {
        break;
      }
    }
    Collections.sort(
      neg,
      new Comparator<Pair>() {
        @Override
        public int compare(Pair o1, Pair o2) {
          return o1.y - o2.y;
        }
      }
    );
    Long dp[][] = new Long[neg.size() + 1][R + 1];
    long y1 = helper(neg, neg.size(), R, dp);
    Collections.reverse(neg);
    for (int i = 0; i < dp.length; i++) {
      Arrays.fill(dp[i], null);
    }
    long y2 = helper(neg, neg.size(), R, dp);
    long x = count + Math.max(y1, y2);
    System.out.println(x);
  }
}
