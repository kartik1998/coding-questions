package Dynamic_Programming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Perfect_Squares_LeetCode {
    public static long helper(int target,List<Integer> A,int n,Long dp[][]){
        if(target==0){
            return 0;
        }
        if(target<0 || n==0){
            return Integer.MAX_VALUE;
        }
        if(dp[target][n]!=null){
            return dp[target][n];
        }
        return dp[target][n]=Math.min(helper(target-A.get(n-1),A,n,dp)+1,helper(target,A,n-1,dp));
    }
    public static int numSquares(int n) {
        List<Integer> A = new ArrayList<>();
        for(int i=1;i<=n;i++){
            int x=i*i;
            if(x<=n){
                A.add(x);
            }else{
                break;
            }
        }
        Long dp[][]=new Long[n+1][A.size()+1];
        return (int)helper(n,A,A.size(),dp);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            System.out.println(numSquares(n));
        }
    }
}
