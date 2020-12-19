package CodeChef;

import java.util.HashMap;
import java.util.Scanner;

public class CSUM {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      HashMap<Long, Long> map = new HashMap<>();
      int N = sc.nextInt();
      long A[] = new long[N];
      long K = sc.nextLong();
      for (int i = 0; i < N; i++) {
        A[i] = sc.nextLong();
        map.put(A[i], map.getOrDefault(A[i], 0L) + 1);
      }
      boolean flag = false;
      for (int i = 0; i < N; i++) {
        if (K - A[i] == A[i]) {
          if (map.get(A[i]) > 1) {
            flag = true;
            break;
          }
        } else {
          if (map.containsKey(K - A[i])) {
            flag = true;
            break;
          }
        }
      }
      if (flag) {
        System.out.println("Yes");
      } else {
        System.out.println("No");
      }
    }
  }
}
