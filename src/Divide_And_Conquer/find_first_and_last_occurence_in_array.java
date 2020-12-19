package Divide_And_Conquer;

import java.util.Scanner;

public class find_first_and_last_occurence_in_array {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int arr[] = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      int x = sc.nextInt();
      System.out.println(
        first_occurence(arr, x) + " " + last_occurence(arr, x)
      );
    }
  }

  public static int first_occurence(int arr[], int x) {
    int s = 0;
    int e = arr.length - 1;
    int index = -1;
    while (s <= e) {
      int mid = (s + e) / 2;
      if (arr[mid] == x) {
        if (mid == s || arr[mid - 1] != x) {
          index = mid;
          break;
        } else {
          e = mid - 1;
        }
      } else if (arr[mid] > x) {
        e = mid - 1;
      } else {
        s = mid + 1;
      }
    }
    return index;
  }

  public static int last_occurence(int arr[], int x) {
    int s = 0;
    int e = arr.length - 1;
    int index = -1;
    while (s <= e) {
      int mid = (s + e) / 2;
      if (arr[mid] == x) {
        if (mid == e || arr[mid + 1] != x) {
          index = mid;
          break;
        } else {
          s = mid + 1;
        }
      } else if (arr[mid] > x) {
        e = mid - 1;
      } else {
        s = mid + 1;
      }
    }
    return index;
  }
}
