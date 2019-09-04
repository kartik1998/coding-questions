package Dynamic_Programming;

import java.util.Scanner;

public class Summing_Pieces {
    public static int helper(int A[],int in){
        if(in==A.length){
            return 0;
        }
        int count=0;
        int sum=0;
        for(int i=in;i<A.length;i++){
            sum+=A[i];
            count+=(sum)*(i-in+1)+helper(A,i+1);
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int A[]=new int[n];
            for(int i=0;i<n;i++){
                A[i]=sc.nextInt();
            }
            System.out.println(helper(A,0));
        }
    }
}
