package HackerEarth;

import java.util.Scanner;

public class Xsquare_And_Coin_Collection {
    public static void main(String args[] ){
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int A[]=new int[n];
            for(int i=0;i<n;i++){
                A[i]=sc.nextInt();
            }
            long curr=0;
            long max=0;
            for(int i=0;i<n;i++){
                if(A[i]<=k){
                    curr+=A[i];
                    max=Math.max(max,curr);
                }else{
                    curr=0;
                }
            }
            System.out.println(max);
        }
    }
}
