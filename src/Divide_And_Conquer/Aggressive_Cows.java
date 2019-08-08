package Divide_And_Conquer;

import java.util.Arrays;
import java.util.Scanner;
import java.lang.*;

public class Aggressive_Cows {
    public static boolean check(long cows,int mid,int x[]){
        cows--;
        if(cows==0){
            return true;
        }
        int j=0;
        for(int i=1;i<x.length;i++){
            if(x[i]-x[j]>=mid){
                j=i;
                cows--;
                if(cows==0){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int cows=sc.nextInt();
            int x[]=new int[n];
            for(int i=0;i<n;i++){
                x[i]=sc.nextInt();
            }
            Arrays.sort(x);
            int s=0;
            int e=x.length-1;
            long ans=-1;
            while(s<=e){
                int mid=(s+e)/2;
                long k=cows;
                if(check(k,mid,x)){
                    ans=Math.max(ans,k);
                    s=mid+1;
                }else{
                    e=mid-1;
                }
            }
            System.out.println(ans);
        }
    }
}
