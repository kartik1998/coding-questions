package Dynamic_Programming;

import java.util.Scanner;

public class Palindrome_Partitioning {
    public static boolean check(char str[],int s,int e){
        for(int i=s,j=e;i<j;i++,j--){
            if(str[i]!=str[j]){
                return false;
            }
        }
        return true;
    }
    public static int minCuts(char s[],int i,int j,Integer dp[][]){
        if(i>=j || check(s,i,j)){
            return 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int min=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int sub_res=minCuts(s,i,k,dp)+1+minCuts(s,k+1,j,dp);
            min=Math.min(sub_res,min);
        }
        return dp[i][j]=min;
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String str=sc.next();
            char s[]=str.toCharArray();
            Integer dp[][]=new Integer[s.length+1][s.length+1];
            System.out.println(minCuts(s,0,s.length-1,dp));
        }
    }
}
