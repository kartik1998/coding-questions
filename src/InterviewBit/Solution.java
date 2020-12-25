public class Solution {

  public int solve(int[] A, int K) {
    int res = 0;
    for (int i = 0; i < K; i++) {
      res += A[i];
    }
    int lsum = res, rsum = 0, idx = K - 1, i = A.length - 1;
    while (idx >= 0) {
      rsum += A[i];
      lsum -= A[idx];
      res = Math.max(lsum + rsum, res);
      idx--;
      i--;
    }
    return res;
  }
}
