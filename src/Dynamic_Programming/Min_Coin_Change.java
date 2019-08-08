package Dynamic_Programming;

import java.util.Scanner;

public class Min_Coin_Change {
    public static long minCoins(int V,int A[]){
        if(V<0){
            return Integer.MAX_VALUE;
        }
        if(V==0){
            return 0;
        }
        long ans=(long)Integer.MAX_VALUE;
        for(int i=0;i<A.length;i++){
            long sub_res=1+minCoins(V-A[i],A);
            ans=Math.min(sub_res,ans);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int V=sc.nextInt();
            int A[]=new int[n];
            for(int i=0;i<n;i++){
                A[i]=sc.nextInt();
            }
            System.out.println(minCoins(V,A));
        }
    }
}
