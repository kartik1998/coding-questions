package CodeForces.Five_Ninety_Eight;

import java.util.Scanner;

public class B {
    public static void swap(int A[],int in1,int in2){
        int temp=A[in1];
        A[in1]=A[in2];
        A[in2]=temp;
    }
    public static void doSwap(int A[],int in1,int in2,int K){
        for(int i=in2;i>in1;i--) {
            swap(A, i - 1, i);
            K--;
        }
    }
    public static void helper(int A[],int index,int K,boolean flag){
        int min=A[index];
        int ind = index;
        for(int i=index+1;i<K;i++){
            if(A[i]<min){
                min=A[i];
                ind=i;
            }
        }
        doSwap(A,index,ind,K);
        if(ind==index){
            flag = false;
        }
        index++;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int K = n-1;
            int A[]=new int[n];
            for(int i=0;i<n;i++){
                A[i]=sc.nextInt();
            }
            while(K>0){
                int m=K;
                int index = 0;
                boolean flag=true;
                helper(A,index,K,flag);
                if(flag==false){
                    break;
                }
                if(m==K){
                    break;
                }
            }
            for(int i:A){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
