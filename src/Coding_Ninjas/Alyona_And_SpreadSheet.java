package Coding_Ninjas;

import java.util.Scanner;

public class Alyona_And_SpreadSheet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int A[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                A[i][j]=sc.nextInt();
            }
        }
        int dp[][]=new int[n][m];
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(A[i][j]>=A[i-1][j]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=i;
                }
            }
        }
        int q=sc.nextInt();
        while(q-->0){
            int l=sc.nextInt()-1;
            int r=sc.nextInt()-1;
            boolean flag=false;
            for(int c=0;c<m;c++){
                if(dp[r][c]<=l){
                    flag=true;
                    break;
                }
            }
            if(flag){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}
