package Geeks_For_Geeks_Important;

import java.util.ArrayList;
import java.util.Collections;

class Solution {

  public ArrayList<Integer> grayCode(int n) {
    ArrayList<String> l = helper(n);
    ArrayList<Integer> ans = new ArrayList<>();
    for (String s : l) {
      ans.add(Integer.parseInt(s));
    }
    return ans;
  }

  public ArrayList<String> helper(int n) {
    ArrayList<String> A = new ArrayList<>();
    ArrayList<String> ans = new ArrayList<>();
    A.add("0");
    A.add("1");
    for (int i = 0; i < n; i++) {
      ArrayList<String> a = new ArrayList<>();
      ArrayList<String> b = new ArrayList<>();
      for (int j = 0; j < A.size(); j++) {
        String s = A.get(j);
        a.add("0" + A.get(j));
        b.add("1" + A.get(j));
        if (s.length() == n) {
          ans.add(s);
        }
      }
      A.clear();
      for (String s : a) {
        A.add(s);
      }
      Collections.reverse(b);
      for (String s : b) {
        A.add(s);
      }
    }
    return ans;
  }
}

public class Gray_Code {

  public static void main(String[] args) {
    Solution ob = new Solution();
    System.out.println(ob.grayCode(10));
  }
}
