package Divide_And_Conquer;

import java.util.Scanner;

public class Painters_Partition_Problem {
    public static boolean check(int A[],int time,int k){
        int count=0;
        int painters=1;
        for(int i=0;i<A.length;i++){
            count+=A[i];
            if(count>time){
                painters++;
                count=A[i];
            }
            if(painters>k){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k=0,n=0;
        if(sc.hasNext()){
            k=sc.nextInt();
        }
        if(sc.hasNext()){
            n=sc.nextInt();
        }
        int A[]=new int[n];
        int s=0;
        int e=0;
        for(int i=0;i<n;i++){
            A[i]=sc.nextInt();
            e+=A[i];
            s=Math.max(s,A[i]);
        }
        int ans=-1;
        while(s<=e){
            int mid=(s+e)/2;
            if(check(A,mid,k)){
                ans=mid;
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        System.out.println(ans);
    }
}
