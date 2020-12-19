package Geeks_For_Geeks_Important;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Check_Palindromic_Ignoring_Spaces {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      String s = br.readLine();
      boolean flag = true;
      for (int i = 0, j = s.length() - 1; i < j;) {
        char a = s.charAt(i);
        char b = s.charAt(j);
        if (a == ' ' && b == ' ') {
          i++;
          j--;
        } else if (a == ' ') {
          i++;
        } else if (b == ' ') {
          j--;
        } else {
          if (a != b) {
            flag = false;
            break;
          }
          i++;
          j--;
        }
      }
      if (flag) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }
}
