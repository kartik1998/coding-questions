package Dynamic_Programming;

import java.util.Scanner;

public class Wine_Problem {
    public static int helper(int arr[],int s,int e,int year,Integer dp[][]){
        if(dp[s][e]!=null){
            return dp[s][e];
        }
        if(s==e){
            return dp[s][e]=year*arr[s];
        }
        int a=arr[s]*year+helper(arr,s+1,e,year+1,dp);
        int b=arr[e]*year+helper(arr,s,e-1,year+1,dp);
        return dp[s][e]=Math.max(a,b);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            Integer dp[][]=new Integer[n+1][n+1];
        System.out.println(helper(arr,0,n-1,1,dp));
    }
}
