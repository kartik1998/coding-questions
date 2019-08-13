package HashMaps_Sets.Prefix_Sum_Based_Questions;

import java.util.HashMap;
import java.util.Scanner;
// LOGIC : sum(i,j) = sum(0,j)-sum(0,i)
// Hence and subarray sum can be represented as sum(i,j)=sum(0,j)-sum(0,i);
// hence sum(0,j)-sum(0,i)=k;
// then sum(0,j)-k = sum(0,i)
// hence search for sum(0,j)-k in hashmap
public class Count_All_Subarrays_With_Sum_Zero {
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
            int currSum=0;
            int res=0;
            for(int i=0;i<n;i++){
                currSum+=A[i];
                if(currSum==0){
                    res+=1;
                }
                if(map.containsKey(currSum)){
                    res+=map.get(currSum);
                    map.put(currSum,map.get(currSum)+1);
                }else{
                    map.put(currSum,1);
                }
            }
            System.out.println(res);
        }
    }
}
