package Dynamic_Programming;

import java.util.Scanner;

public class MIn_Insertions_To_Make_String_Palindrome {
    public static int minInsertions(String str,int s,int e,Integer dp[][]){
        if(s==e){
            return dp[s][e]=0;
        }
        if(e==s+1){
            if(str.charAt(s)==str.charAt(e)){
                return dp[s][e]=0;
            }
            return dp[s][e]=1;
        }
        if(str.charAt(s)==str.charAt(e)){
            return dp[s][e]=minInsertions(str,s+1,e-1,dp);
        }
        return dp[s][e]=Math.min(minInsertions(str,s+1,e,dp),minInsertions(str,s,e-1,dp))+1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String str=sc.next();
            Integer dp[][]=new Integer[str.length()+1][str.length()+1];
            System.out.println(minInsertions(str,0,str.length()-1,dp));
        }
    }
}
