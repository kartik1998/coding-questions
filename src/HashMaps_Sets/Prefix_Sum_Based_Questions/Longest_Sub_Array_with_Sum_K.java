package HashMaps_Sets.Prefix_Sum_Based_Questions;

import java.util.HashMap;
import java.util.Scanner;
// LOGIC : sum(i,j) = sum(0,j)-sum(0,i)
// Hence and subarray sum can be represented as sum(i,j)=sum(0,j)-sum(0,i);
// hence sum(0,j)-sum(0,i)=k;
// then sum(0,j)-k = sum(0,i)
// hence search for sum(0,j)-k in hashmap
public class Longest_Sub_Array_with_Sum_K {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int K=sc.nextInt();
            int A[]=new int[n];
            for(int i=0;i<n;i++){
                A[i]=sc.nextInt();
            }
            int curr_sum=0;
            HashMap<Integer,Integer> map = new HashMap<>();
            int max=0;
            for(int i=0;i<n;i++){
                curr_sum+=A[i];
                if(curr_sum==K){
                    max=Math.max(max,i+1);
                }
                if(map.containsKey(curr_sum-K)){
                    max=Math.max(i-map.get(curr_sum-K),max);
                }
                if(!map.containsKey(curr_sum)){
                    map.put(curr_sum,i);
                }
            }
            System.out.println(max);
        }
    }
}
