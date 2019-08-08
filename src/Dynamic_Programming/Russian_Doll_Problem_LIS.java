package Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;
class pair implements Comparable<pair>{
    int wd,ht;
    pair(int x,int y){
        this.wd=x;
        this.ht=y;
    }
    public int compareTo(pair p){
        return this.wd-p.wd;
    }
}
public class Russian_Doll_Problem_LIS {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int wd[]=new int[n];
            int ht[]=new int[n];
            for(int i=0;i<n;i++){
                wd[i]=sc.nextInt();
            }
            for(int i=0;i<n;i++){
                ht[i]=sc.nextInt();
            }
            pair A[]=new pair[n];
            for(int i=0;i<n;i++){
                A[i]=new pair(wd[i],ht[i]);
            }
            Arrays.sort(A);
            int dp[]=new int[n];
            dp[0]=1;
            int max=1;
            for(int i=1;i<n;i++){
                dp[i]=1;
                for(int j=i-1;j>=0;j--){
                    if(A[i].ht>A[j].ht && A[i].wd>A[j].wd){
                        dp[i]=Math.max(dp[i],dp[j]+1);
                    }
                }
                max=Math.max(dp[i],max);
            }
            System.out.println(max);
        }
    }
}
