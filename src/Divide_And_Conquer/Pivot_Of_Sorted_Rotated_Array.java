package Divide_And_Conquer;

import java.util.Scanner;

public class Pivot_Of_Sorted_Rotated_Array {
    public static int helper(int A[],int s,int e){
        if(s>e){
            return -1;
        }
        int mid=(s+e)/2;
        if(mid<e && A[mid]>A[mid+1]){
            return mid;
        }else if(mid>s && A[mid]<A[mid-1]){
            return mid-1;
        }else if(A[mid]>A[s]){
            return helper(A,mid+1,e);
        }else{
            return helper(A,s,mid-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=0;
        if(sc.hasNext()){
            n=sc.nextInt();
        }
        int A[]=new int[n];
        for(int i=0;i<n;i++) {
            if (sc.hasNext()) {
                A[i] = sc.nextInt();
            }
        }
        System.out.println(helper(A,0,n-1));
    }
}
