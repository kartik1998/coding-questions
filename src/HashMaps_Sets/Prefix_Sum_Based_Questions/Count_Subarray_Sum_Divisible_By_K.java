package HashMaps_Sets.Prefix_Sum_Based_Questions;

import java.util.HashMap;
import java.util.Scanner;
/*
  sum(i, j) = sum(0, j) - sum(0, i-1)
Sum for any subarray can be written as q*k + rem where q
is a quotient and rem is remainder
Thus,
    sum(i, j) = (q1 * k + rem1) - (q2 * k + rem2)
    sum(i, j) = (q1 - q2)k + rem1-rem2

We see, for sum(i, j) i.e. for sum of any subarray to be
divisible by k, the RHS should also be divisible by k.
(q1 - q2)k is obviously divisible by k, for (rem1-rem2) to
follow the same, rem1 = rem2 where
 */
public class Count_Subarray_Sum_Divisible_By_K {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int K=sc.nextInt();
            int A[]=new int[N];
            for(int i=0;i<N;i++){
                A[i]=sc.nextInt();
            }
            HashMap<Integer,Integer> map = new HashMap<>();
            int curr_sum=0;
            int res=0;
            for(int i=0;i<A.length;i++){
                curr_sum+=A[i];
                int key=((curr_sum%K)+K)%K;
                if(key==0){
                    res++;
                }
                if(map.containsKey(key)){
                    res+=map.get(key);
                }else{
                    map.put(key,1);
                }
            }
            System.out.println(res);

        }
    }
}
