package HashMaps_Sets.Prefix_Sum_Based_Questions;

import java.util.HashMap;
import java.util.Scanner;
// LOGIC : sum(i,j) = sum(0,j)-sum(0,i)
// Hence and subarray sum can be represented as sum(i,j)=sum(0,j)-sum(0,i);
// hence sum(0,j)-sum(0,i)=k;
// then sum(0,j)-k = sum(0,i)
// hence search for sum(0,j)-k in hashmap
public class Longest_Substring_With_Equal_zeroes_And_Ones {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            char s[]=sc.next().toCharArray();
            int A[]=new int[s.length];
            for(int i=0;i<A.length;i++){
                if(s[i]=='0'){
                    A[i]=-1;
                }else{
                    A[i]=s[i]-'0';
                }
            }
            HashMap<Integer,Integer> map = new HashMap<>();
            int curr_sum=0;
            int res=0;
            for(int i=0;i<A.length;i++){
                curr_sum+=A[i];
                if(curr_sum==0){
                    res=Math.max(res,i+1);
                }
                if(map.containsKey(curr_sum)){
                    res=Math.max(res,i-map.get(curr_sum));
                }else{
                    map.put(curr_sum,i);
                }
            }
            System.out.println(res);
        }
    }
}
