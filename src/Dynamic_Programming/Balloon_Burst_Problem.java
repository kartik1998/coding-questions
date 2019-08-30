package Dynamic_Programming;

import java.util.Scanner;

public class Balloon_Burst_Problem {
    public static int Burst(int A[],int i,int j,Integer dp[][]){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int max=0;
        int left=(i-1<0?1:A[i-1]);
        int right=(j+1>=A.length?1:A[j+1]);
        for(int k=i;k<=j;k++){
            int sub=Burst(A,k+1,j,dp)+Burst(A,i,k-1,dp)+left*A[k]*right;
            max=Math.max(max,sub);
        }
        return dp[i][j]=max;
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
            Integer dp[][]=new Integer[A.length+1][A.length+1];
            System.out.println(Burst(A,0,A.length-1,dp));
        }
    }
}
