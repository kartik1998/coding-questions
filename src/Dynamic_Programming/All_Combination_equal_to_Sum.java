package Dynamic_Programming;

import java.util.Scanner;

public class All_Combination_equal_to_Sum {
    public static int helper(int A[],int sum,int in){
        if(in>=A.length){
            return 0;
        }
        if(sum==0){
            return 1;
        }
        if(sum>=A[in]){
            return helper(A,sum-A[in],in)+helper(A,sum,in+1);
        }else{
            return helper(A,sum,in+1);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int sum=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            System.out.println(helper(arr,sum,0));
        }
    }
}
