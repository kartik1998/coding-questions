package Dynamic_Programming;

import java.util.Scanner;

public class Subsequence_sum_present {
    public static boolean helper(int A[],int sum,int n){
        if(sum==0){
            return true;
        }
        if(n==0 || sum<0){
            return false;
        }
        return helper(A,sum-A[n-1],n-1)|| helper(A,sum,n-1);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int A[]=new int[n];
            for(int i=0;i<n;i++){
                A[i]=sc.nextInt();
            }
            int sum=sc.nextInt();
            System.out.println(helper(A,sum,n));
        }
    }
}
