package HackerEarth;

import java.util.Scanner;

public class Vaishu_And_Tower_Arrangements {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int A[]=new int[n];
            for(int i=0;i<n;i++){
                A[i]=sc.nextInt();
            }
            if(n==2){
                if (A[0]==-1){
                    if(A[1]==-1){
                        System.out.println("1");
                    }else{
                        System.out.println("0");
                    }
                }else{
                    if(A[1]==1){
                        System.out.println("1");
                    }else{
                        System.out.println("2");
                    }
                }
                continue;
            }
            int left[]=new int[n];
            int right[]=new int[n];
            left[0]=(A[0]==1?1:0);
            right[n-1]=(A[n-1]==-1?1:0);
            for(int i=1;i<n-1;i++){
                if(A[i]==1){
                    left[i]=left[i-1]+1;
                }else{
                    left[i]=left[i-1];
                }
            }
            for(int i=n-2;i>=1;i--){
                if(A[i]==-1){
                    right[i]=right[i+1]+1;
                }else{
                    right[i]=right[i+1];
                }
            }
            int min=Integer.MAX_VALUE;
            for(int i=1;i<n-1;i++){
                min=Math.min(left[i]+right[i+1],min);
                min=Math.min(left[i-1]+right[i],min);
            }
            System.out.println(min);
        }
    }
}
