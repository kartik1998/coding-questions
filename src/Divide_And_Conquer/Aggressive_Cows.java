package Divide_And_Conquer;

import java.util.Arrays;
import java.util.Scanner;
import java.lang.*;

public class Aggressive_Cows {
    public static boolean check(int A[],int cows,int d){
        int count=1;
        int j=0;
        for(int i=1;i<A.length;i++){
            if(A[i]-A[j]>=d){
                count++;
                j=i;
            }
            if(count==cows){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=0,n=0,cows=0;
        if(sc.hasNext()){
            t=sc.nextInt();
        }
        while(t-->0){
            if(sc.hasNext()){
                n=sc.nextInt();
            }
            if(sc.hasNext()){
                cows=sc.nextInt();
            }
            int A[]=new int[n];
            for(int i=0;i<n;i++){
                if(sc.hasNext()) {
                    A[i] = sc.nextInt();
                }
            }
            Arrays.sort(A);
            int s=0;
            int e=A[n-1]-A[0];
            int ans=-1;
            while(s<=e){
                int mid=(s+e)/2;
                if(check(A,cows,mid)){
                    System.out.println("true");
                    ans=Math.max(ans,mid);
                    s=mid+1;
                }else{
                    System.out.println("false");
                    e=mid-1;
                }
            }
            System.out.println(ans);
        }
    }
}
