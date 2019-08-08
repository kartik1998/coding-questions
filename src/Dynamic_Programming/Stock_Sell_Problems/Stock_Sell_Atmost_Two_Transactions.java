package Dynamic_Programming.Stock_Sell_Problems;

import java.util.Scanner;
//TEST CASE :
//1
//15
//8 6 4 7 11 15 10 6 3 5 7 10 11 18 12
public class Stock_Sell_Atmost_Two_Transactions {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int A[]=new int[n];
            for(int i=0;i<n;i++){
                A[i]=sc.nextInt();
            }
            int left[]=new int[n];
            int right[]=new int[n];
            int min=A[0];
            for(int i=1;i<n;i++){
                left[i]=Math.max(left[i-1],A[i]-min);
                min=Math.min(A[i],min);
            }
            int max=A[n-1];
            for(int i=n-2;i>=0;i--){
                right[i]=Math.max(right[i+1],max-A[i]);
                max=Math.max(max,A[i]);
            }
            int ans=0;
            for(int i=0;i<n;i++){
                ans=Math.max(ans,left[i]+right[i]);
            }
            System.out.println(ans);

        }
    }

}
