package Dynamic_Programming;

import java.util.Scanner;

public class Count_Substrings_Of_Nature_a_n_b_n_c_n {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      String s = sc.next();
      int aCount = 0;
      int bCount = 0;
      int cCount = 0;
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == 'a') {
          aCount = 1 + 2 * aCount;
        } else if (s.charAt(i) == 'b') {
          bCount = aCount + 2 * bCount;
        } else {
          cCount = bCount + 2 * cCount;
        }
      }
      System.out.println(cCount);
    }
  }
}
