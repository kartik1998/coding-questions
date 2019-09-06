package HackerEarth;

import java.util.Scanner;

public class K_Cut_And_Product {
    public static int cutter(int in,int A[],int r){
        int mul=1;
        for(int i=in;i<=r;i++){
            mul=mul*A[i];
        }
        return mul;
    }
    public static int helper(int A[],int in,int k){
        if(k==0){
            return cutter(in,A,A.length-1);
        }
        int sum=0;
        for(int i=in;i<A.length;i++){
            if(A.length-i-1<k){
                break;
            }
            int sub=cutter(in,A,i)+helper(A,i+1,k-1);
            sum+=sub;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int A[]=new int[n];
        for(int i=0;i<n;i++){
            A[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        System.out.println(helper(A,0,k)%720720);
    }
}
