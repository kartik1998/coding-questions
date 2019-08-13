package HashMaps_Sets.Prefix_Sum_Based_Questions;

import java.util.HashMap;
import java.util.Scanner;
// We will use the count all sub-arrays with sum zero approach here.
public class Count_Subarrays_With_Equal_Zeroes_and_ones {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int A[]=new int[n];
            for(int i=0;i<n;i++){
                int x=sc.nextInt();
                if(x==0){
                    A[i]=-1;
                }else{
                    A[i]=1;
                }
            }
            int curr_sum=0;
            HashMap<Integer,Integer> map = new HashMap<>();
            int res=0;
            for(int i=0;i<n;i++){
                curr_sum+=A[i];
                if(curr_sum==0){
                    res++;
                }
                if(map.containsKey(curr_sum)){
                    res+=map.get(curr_sum);
                    map.put(curr_sum,map.get(curr_sum)+1);
                }else{
                    map.put(curr_sum,1);
                }
            }
            System.out.println(res);

        }
    }
}
