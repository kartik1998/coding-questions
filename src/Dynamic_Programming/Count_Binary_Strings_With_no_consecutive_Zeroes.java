package Dynamic_Programming;

import java.util.Scanner;
// FIBONACCI SEQUENCE :
public class Count_Binary_Strings_With_no_consecutive_Zeroes {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int dp[]=new int[n+1];
            for(int i=0;i<=n;i++){
                if(i==0){
                    dp[i]=1;
                }else if(i==1){
                    dp[i]=2;
                }
                else{
                    dp[i]=dp[i-1]+dp[i-2];
                }
            }
            System.out.println(dp[n]*dp[n]);
        }
    }
}
