package Dynamic_Programming;

import java.util.Scanner;

public class fairCut_HackerRank {
    static int calculate(int A[],boolean vis[]){
        int sum=0;
        for(int i=0;i<A.length;i++){
            for(int j=i+1;j<A.length;j++){
                if(vis[i]){
                    if(!vis[j]){
                        sum+=Math.abs(A[i]-A[j]);
                    }
                }else{
                    if(vis[j]){
                        sum+=Math.abs(A[i]-A[j]);
                    }
                }
            }
        }
        return sum;
    }
    static int helper(int k,int A[],int n,boolean vis[]){
        if(k==0){
            return calculate(A,vis);
        }
        if(n==0){
            return Integer.MAX_VALUE;
        }
        boolean vis1[]=new boolean[A.length];
        for(int i=0;i<vis1.length;i++){
            vis1[i]=vis[i];
        }
        vis1[n-1]=true;
        return Math.min(helper(k-1,A,n-1,vis1),helper(k,A,n-1,vis));
    }
    static int fairCut(int k,int A[]){
        boolean vis[]=new boolean[A.length];
        return helper(k,A,A.length,vis);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            int n=sc.nextInt(),k=sc.nextInt();
            int A[]=new int[n];
            for(int i=0;i<n;i++){
                A[i]=sc.nextInt();
            }
        System.out.println(fairCut(k,A));
    }
}
