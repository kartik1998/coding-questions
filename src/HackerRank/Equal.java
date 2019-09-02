package HackerRank;

import java.util.Arrays;
import java.util.Scanner;

//o make things difficult, she must equalize the number of chocolates in a series of operations. For each operation,
// she can give  chocolates to all but one colleague. Everyone who gets chocolate in a round receives the same number
// of pieces.
//For example, assume the starting distribution is . She can give  bars to the first two and the distribution will
// be . On the next round, she gives the same two  bars each, and everyone has the same number:  .
//Given a starting distribution, calculate the minimum number of operations needed so that every colleague has
// the same number of chocolates.
public class Equal {
    public static int minSteps(int n,Integer dp[]){
        if(n==0){
            return dp[n]=0;
        }
        if(n<0){
            return Integer.MAX_VALUE;
        }
        if(dp[n]!=null){
            return dp[n];
        }
        return dp[n]=Math.min(minSteps(n-1,dp),Math.min(minSteps(n-2,dp),minSteps(n-5,dp)))+1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int A[]=new int[n];
            for(int i=0;i<n;i++){
                A[i]=sc.nextInt();
            }
            int max=0;
            for(int i=0;i<n;i++){
                Integer dp[]=new Integer[A[i]+1];
                max=Math.max(minSteps(A[i],dp),max);
            }
            System.out.println(max);
        }
    }
}
