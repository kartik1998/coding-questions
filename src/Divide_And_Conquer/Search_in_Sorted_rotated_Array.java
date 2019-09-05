package Divide_And_Conquer;

import java.util.Scanner;

public class Search_in_Sorted_rotated_Array {
    public static int helper(int A[],int x,int s,int e){
        if(s>e){
            return -1;
        }
        int mid=(s+e)/2;
        if(A[mid]==x){
            return mid;
        }else{
            if(x<=A[e]){
                if(A[mid]<x || A[mid]>A[e]){
                    return helper(A,x,mid+1,e);
                }else{
                    return helper(A,x,s,mid-1);
                }
            }else{
                if(A[mid]>x || A[mid]<A[s]){
                    return helper(A,x,s,mid-1);
                }else{
                    return helper(A,x,mid+1,e);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=0;
        if(sc.hasNext()){
            n=sc.nextInt();
        }
        int A[]=new int[n];
        for(int i=0;i<n;i++){
            if(sc.hasNext()){
                A[i]=sc.nextInt();
            }
        }
        int x=0;
        if(sc.hasNext()){
            x=sc.nextInt();
        }
        System.out.println(helper(A,x,0,n-1));
    }
}
