package Dynamic_Programming;

import java.util.Scanner;

public class Max_Sum_Rectangle_In_2D_SubArray {
    public static int kadanes(int A[]){
        int curr=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            curr+=A[i];
            max=Math.max(curr,max);
            curr=Math.max(curr,0);
        }
        return max;
    }
    public static int sum(int A[][],int l,int r,int i){
        int sum=0;
        for(int j=l;j<=r;j++){
            sum+=A[i][j];
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int A[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    A[i][j] = sc.nextInt();
                }
            }
            int dp[]=new int[n];
            int ans=Integer.MIN_VALUE;
            for(int l=0;l<n;l++){
                for(int r=l;r<m;r++){
                    int k=0;
                    for(int i=0;i<n;i++){
                        dp[k++]=sum(A,l,r,i);
                    }
                    ans=Math.max(ans,kadanes(dp));
                }
            }
            System.out.println(ans);
        }
    }
}
