package Dynamic_Programming;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Longest_Arithematic_Progression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            HashMap<Integer,Integer> dp[]=new HashMap[n];
            for(int i=0;i<n;i++){
                dp[i]=new HashMap<>();
            }
            for(int i=1;i<n;i++){
                for(int j=i-1;j>=0;j--){
                    int d=arr[i]-arr[j];
                    if(dp[j].containsKey(d)){
                        if(dp[i].containsKey(d) && dp[i].get(d)>dp[j].get(d)){
                            continue;
                        }else{
                            dp[i].put(d,dp[j].get(d)+1);
                        }
                    }else{
                        if(!dp[i].containsKey(d)){
                            dp[i].put(d,1);
                        }
                    }
                }
            }
            int max=0;
            for(int i=0;i<n;i++){
                for(Map.Entry in:dp[i].entrySet()){
                    max=Math.max(max,(int)in.getValue());
                }
            }
            System.out.println(max+1);
        }
    }
}
