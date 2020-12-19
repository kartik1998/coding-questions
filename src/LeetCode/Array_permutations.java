package LeetCode;

import java.util.*;

public class Array_permutations {

  static List<List<Integer>> res = new ArrayList<>();

  public static void permute(List<Integer> input, List<Integer> output) {
    if (input.size() == 0) {
      res.add(new ArrayList<>(output));
      return;
    }
    for (int i = 0; i < input.size(); i++) {
      List<Integer> sub = new ArrayList<>(input);
      sub.remove(i);
      List<Integer> out = new ArrayList<>(output);
      out.add(input.get(i));
      permute(sub, out);
    }
  }

  public static List<List<Integer>> permute(int[] A) {
    List<Integer> sub = new ArrayList<>();
    List<Integer> input = new ArrayList<>();
    for (int i : A) {
      input.add(i);
    }
    permute(input, sub);
    return res;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int A[] = new int[n];
    for (int i = 0; i < n; i++) {
      A[i] = sc.nextInt();
    }
    System.out.println(permute(A));
  }
}
