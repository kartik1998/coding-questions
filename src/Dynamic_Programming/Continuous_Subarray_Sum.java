package Dynamic_Programming;

import java.util.Scanner;

public class Continuous_Subarray_Sum {
    static class Solution {
        public boolean checkSubarraySum(int[] A, int k) {
            int sum = 0;
            int P[] = new int[A.length];
            for(int i=0;i<A.length;i++){
                sum+=A[i];
                P[i]=sum;
            }
            for(int i=0;i<A.length;i++){
                for(int j=i-2;j>=-1;j--){
                    int x;
                    if(j==-1){
                        x=P[i];
                    }else{
                        x=P[i]-P[j];
                    }
                    if(k!=0 && x%k==0){
                        return true;
                    }else if(k==0 && x==0){
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int A[]=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        Solution ob = new Solution();
        int k=sc.nextInt();
        System.out.println(ob.checkSubarraySum(A,k));
    }
}
