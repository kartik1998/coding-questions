package HashMaps_Sets.Prefix_Sum_Based_Questions;

import java.util.HashMap;
import java.util.Scanner;
// Use the same approach as count sub-arrays with sum K
public class Count_Subarrays_with_Sum_K_for_Binary_Array {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int A[]=new int[n];
            for(int i=0;i<n;i++){
                A[i]=sc.nextInt();
            }
            HashMap<Integer,Integer> map = new HashMap<>();
            int sum=sc.nextInt();
            int curr_sum=0;
            int res=0;
            for(int i=0;i<A.length;i++){
                curr_sum+=A[i];
                if(curr_sum==sum){
                    res++;
                }
                if(map.containsKey(curr_sum-sum)){
                    res+=map.get(curr_sum-sum);
                }
                if(!map.containsKey(curr_sum)){
                    map.put(curr_sum,1);
                }else{
                    map.put(curr_sum,map.get(curr_sum)+1);
                }
            }
            System.out.println(res);

        }
    }
}
