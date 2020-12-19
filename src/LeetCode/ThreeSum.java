package LeetCode;

import java.util.*;

public class ThreeSum {

  static HashSet<List<Integer>> set = new HashSet<>();

  public static List<List<Integer>> threeSum(int[] A) {
    Arrays.sort(A);
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> sub = new ArrayList<>();
    for (int i = 0; i < A.length; i++) {
      int j = i + 1;
      int k = A.length - 1;
      while (j < k) {
        int sum = A[i] + A[j] + A[k];
        if (sum == 0) {
          sub.add(A[i]);
          sub.add(A[j]);
          sub.add(A[k]);
          if (!set.contains(sub)) {
            res.add(new ArrayList<>(sub));
            set.add(sub);
          }
          sub.clear();
          j++;
        } else if (sum > 0) {
          k--;
        } else {
          j++;
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int A[] = new int[n];
    for (int i = 0; i < n; i++) {
      A[i] = sc.nextInt();
    }
    System.out.println(threeSum(A));
  }
}
