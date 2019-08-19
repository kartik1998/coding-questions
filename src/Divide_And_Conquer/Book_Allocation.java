package Divide_And_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Book_Allocation {
    public static boolean check(int A[],long pages,int M){
        int count=1;
        long sum=0;
        for(int i=0;i<A.length;i++){
            if(sum+A[i]>pages){
                sum=A[i];
                count++;
                if(count>M){
                    return false;
                }
            }else{
                sum+=A[i];
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            String str[]=br.readLine().split(" ");
            int A[]=new int[n];
            long s=0,e=0;
            for(int i=0;i<n;i++){
                A[i]=Integer.parseInt(str[i]);
                e+=A[i];
                s=Math.max(s,A[i]);
            }
            int M=Integer.parseInt(br.readLine());
            if(M>n){
                System.out.println(-1);
                continue;
            }
            long ans=-1;
            while(s<=e){
                long mid=(s+e)/2;
                if(check(A,mid,M)){
                    e=mid-1;
                    if(ans==-1 || ans>mid){
                        ans=mid;
                    }
                }else{
                    s=mid+1;
                }
            }
            System.out.println(ans);
        }
    }
}
