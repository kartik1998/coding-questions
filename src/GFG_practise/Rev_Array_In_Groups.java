package random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rev_Array_In_Groups {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCases = Integer.parseInt(br.readLine());
    while (testCases-- > 0) {
      String ip1 = br.readLine();
      int N = Integer.parseInt(ip1.split(" ")[0]);
      int K = Integer.parseInt(ip1.split(" ")[1]);
      String ip2[] = br.readLine().split(" ");
      int A[] = new int[N];
      for (int i = 0; i < N; i++) {
        A[i] = Integer.parseInt(ip2[i]);
      }
      for (int i = 0; i < N; i += K) {
        int start = i, end = Math.min(i + K - 1, N - 1);
        while (start < end) {
          int temp = A[start];
          A[start] = A[end];
          A[end] = temp;
          start++;
          end--;
        }
      }
      for (int i = 0; i < N; i++) {
        System.out.print(A[i] + " ");
      }
      System.out.println();
    }
  }
}
