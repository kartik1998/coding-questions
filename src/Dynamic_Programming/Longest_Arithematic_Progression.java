package Dynamic_Programming;

import java.util.HashMap;
import java.util.Scanner;

public class Longest_Arithematic_Progression {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int A[]=new int[N];
            for(int i=0;i<N;i++){
                A[i]=sc.nextInt();
            }
            HashMap<Integer,Integer> dp[]=new HashMap[N];
            for(int i=0;i<N;i++){
                dp[i]=new HashMap<>();
            }
            int max=0;
            for(int i=1;i<N;i++){
                for(int j=i-1;j>=0;j--){
                    int d=A[i]-A[j];
                    if(!dp[i].containsKey(d)){
                        if(dp[j].containsKey(d)){
                            dp[i].put(d,dp[j].get(d)+1);
                        }else{
                            dp[i].put(d,1);
                        }
                    }else{
                        if(dp[j].containsKey(d)){
                            int c=dp[j].get(d)+1;
                            if(c>dp[i].get(d)){
                                dp[i].put(d,c);
                            }
                        }
                    }
                    max=Math.max(dp[i].get(d),max);
                }
            }
            System.out.println(max+1);
        }
    }
}
