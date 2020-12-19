package LeetCode;

import java.util.Arrays;
import java.util.Scanner;

public class ZigZag_Conversion {

  public static void populate(char A[][]) {
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A[i].length; j++) {
        A[i][j] = '.';
      }
    }
  }

  public static void print(char A[][]) {
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A[i].length; j++) {
        System.out.print(A[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    int numRows = sc.nextInt();
    char A[][] = new char[numRows][s.length()];
    populate(A);
    int index = 0;
    int i = 0, j = 0;
    while (index < s.length()) {
      while (index < s.length() && i < numRows) {
        A[i][j] = s.charAt(index);
        index++;
        i++;
      }
      j++;
      i = i - 2;
      while (index < s.length() && i > 0) {
        A[i][j] = s.charAt(index);
        i--;
        j++;
        index++;
      }
    }
    print(A);
    System.out.println();
    String res = "";
    for (i = 0; i < A.length; i++) {
      for (j = 0; j < A[i].length; j++) {
        if (A[i][j] != '.') {
          res += A[i][j];
        }
      }
    }
    System.out.println(res);
  }
}
