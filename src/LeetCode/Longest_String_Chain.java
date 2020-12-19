package LeetCode;

import java.util.*;

public class Longest_String_Chain {

  public static boolean similar(String a, String b) {
    if (b.length() - a.length() != 1) {
      return false;
    }
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < b.length(); i++) {
      map.put(b.charAt(i), map.getOrDefault(b.charAt(i), 0) + 1);
    }
    for (int i = 0; i < a.length(); i++) {
      char ch = a.charAt(i);
      if (!map.containsKey(ch)) {
        return false;
      } else {
        if (map.get(ch) == 1) {
          map.remove(ch);
        } else {
          map.put(ch, map.get(ch) - 1);
        }
      }
    }
    return map.size() == 1;
  }

  public static int longestStrChain(String[] words) {
    Arrays.sort(
      words,
      new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
          return o1.length() < o2.length() ? 1 : 0;
        }
      }
    );
    int res = 0;
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      int len = 1;
      for (int j = i + 1; j < words.length; j++) {
        if (similar(word, words[j])) {
          word = words[j];
          len++;
        }
        res = Math.max(len, res);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String words[] = new String[n];
    for (int i = 0; i < n; i++) {
      words[i] = sc.next();
    }
  }
}
