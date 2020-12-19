package Dynamic_Programming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//You are given n articles
//And for every article you are given ki choices where i is the article number
//You have to pick exactly 1 from each type of article
// And you need to do this in a manner in which you spend as much money as possible while staying in budget b
public class Selecting_Articles_Maximizing_Cost_Under_Budget {

  public static int helper(
    List<List<Integer>> cost,
    int in,
    int Budget,
    int Paise
  ) {
    if (in == cost.size() - 1) {
      if (Paise <= 0) {
        return Integer.MAX_VALUE;
      }
      int min = Integer.MAX_VALUE;
      for (int i : cost.get(in)) {
        if (Budget >= Paise + i) {
          if (min > Budget - (Paise + i)) {
            min = Budget - (Paise + i);
          }
        }
      }
      return min;
    }
    int min = Integer.MAX_VALUE;
    for (int i : cost.get(in)) {
      if (Budget >= Paise + i) {
        min = Math.min(min, helper(cost, in + 1, Budget, Paise + i));
      }
    }
    return min;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int budget = sc.nextInt();
      List<List<Integer>> cost = new ArrayList<>();
      // if(input==-1 then close list)
      for (int i = 0; i < n; i++) {
        List<Integer> list = new ArrayList<>();
        while (true) {
          int x = sc.nextInt();
          if (x == -1) {
            break;
          }
          list.add(x);
        }
        cost.add(new ArrayList<>(list));
      }
      System.out.println(cost);
      System.out.println(helper(cost, 0, budget, 0));
    }
  }
}
