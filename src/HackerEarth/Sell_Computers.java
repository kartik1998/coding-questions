package HackerEarth;

import java.util.HashMap;
import java.util.Scanner;

public class Sell_Computers {

  public static boolean compare(String a, String b) {
    int n = a.length();
    int m = b.length();
    for (int i = 0; i < Math.min(n, m); i++) {
      if (b.charAt(i) - 'a' < a.charAt(i) - 'a') {
        return true;
      }
    }
    return false;
  }

  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String A[] = new String[n];
    HashMap<String, Integer> map = new HashMap<>();
    int max = 0;
    for (int i = 0; i < n; i++) {
      A[i] = sc.next();
      map.put(A[i], map.getOrDefault(A[i], 0) + 1);
      max = Math.max(max, map.get(A[i]));
    }
    String ans = "";
    for (int i = 0; i < A.length; i++) {
      String s = A[i];
      if (map.get(s) == max) {
        if (ans == "" || compare(ans, s)) {
          ans = s;
        }
      }
    }
    System.out.println(ans);
  }
}
