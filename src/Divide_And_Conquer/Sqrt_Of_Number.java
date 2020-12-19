package Divide_And_Conquer;

import java.util.Scanner;

public class Sqrt_Of_Number {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int x = sc.nextInt();
      if (x < 2) {
        System.out.println(x);
        continue;
      }
      int s = 1;
      int e = x;
      int ans = -1;
      while (s <= e) {
        int mid = (s + e) / 2;
        if (x / mid == mid) {
          ans = mid;
          break;
        } else if (x / mid > mid) {
          s = mid + 1;
          ans = mid;
        } else {
          e = mid - 1;
        }
      }
      System.out.println(ans);
    }
  }
}
