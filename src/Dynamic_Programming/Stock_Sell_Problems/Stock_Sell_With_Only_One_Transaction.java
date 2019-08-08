package Dynamic_Programming.Stock_Sell_Problems;

import java.util.Scanner;

public class Stock_Sell_With_Only_One_Transaction {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int A[]=new int[n];
            for(int i=0;i<n;i++){
                A[i]=sc.nextInt();
            }
            int max=0;
            int min_Element=A[0];
            for(int i=1;i<n;i++){
                max=Math.max(A[i]-min_Element,max);
                min_Element=Math.min(A[i],min_Element);
            }
            System.out.println(max);
        }
    }
}
