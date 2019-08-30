package Dynamic_Programming;

import java.util.Scanner;

public class Ways_To_Decode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String s=sc.next();
            int n=s.length();
            int dp[]=new int[n+1];
            dp[0]=1;
            dp[1]=1;
            if(s.charAt(0)=='0'){
                dp[1]=0;
            }
            for(int i=2;i<=n;i++){
                int N=s.charAt(i-2)-'0';
                int M=s.charAt(i-1)-'0';
                if(M!=0){
                    dp[i]+=dp[i-1];
                }
                if(N==1 || N==2 && M<7){
                    dp[i]+=dp[i-2];
                }
            }
            System.out.println(dp[n-1]);
        }
    }
}
