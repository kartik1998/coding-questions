package Dynamic_Programming.Stock_Sell_Problems;

import java.util.Scanner;

public class Stock_Sell_With_Infinite_Transactions {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int A[]=new int[n];
            for(int i=0;i<n;i++){
                A[i]=sc.nextInt();
            }
            int i=0;
            boolean flag=false;
            for(int j=i+1;j<n;j++){
                if(A[j]<A[j-1] && j!=i+1){
                    int J=j-1;
                    flag=true;
                    System.out.print("("+i+" "+J+") ");
                    i=j;
                }else if(A[j]<A[j-1] && j==i+1){
                    i=j;
                }
                if(j==n-1 && A[j]>A[j-1]){
                    flag=true;
                    System.out.print("("+i+" "+j+") ");
                }
            }
            if(!flag){
                System.out.println("No Profit");
                continue;
            }
            System.out.println();
        }
    }
}
