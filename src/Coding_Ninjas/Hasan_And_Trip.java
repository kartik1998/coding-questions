package Coding_Ninjas;

import java.util.Scanner;
import java.text.DecimalFormat;
public class Hasan_And_Trip {
    public static double Distance(int x1,int y1,int x2,int y2){
        return Math.sqrt(((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1)));
    }
    public static double helper(int A[][],int curr,int prev,Double dp[][]){
        if(curr==A.length){
            return 0;
        }
        if(curr==A.length-1){
            return A[curr][2]-Distance(A[prev][0],A[prev][1],A[curr][0],A[curr][1]);
        }
        if(dp[curr][prev]!=null){
            return dp[curr][prev];
        }
        return dp[curr][prev]=Math.max(helper(A,curr+1,prev,dp),helper(A,curr+1,curr,dp)+A[curr][2]-Distance(A[prev][0],A[prev][1],A[curr][0],A[curr][1]));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int A[][]=new int[n][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                A[i][j]=sc.nextInt();
            }
        }
        DecimalFormat df = new DecimalFormat("#.######");
        Double dp[][]=new Double[n+1][n+1];
        double ans=helper(A,1,0,dp)+A[0][2];
        System.out.format("%.6f",ans);

    }
}