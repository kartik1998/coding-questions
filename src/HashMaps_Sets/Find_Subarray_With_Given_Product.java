package HashMaps_Sets;

import java.util.Scanner;

public class Find_Subarray_With_Given_Product {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int A[]=new int[n];
            for(int i=0;i<n;i++){
                A[i]=sc.nextInt();
            }
            int K=sc.nextInt();
            int curr_Product=1;
            int l=0;
            int r=0;
            boolean flag=false;
            while(r<A.length){
                if(curr_Product*A[r]==K){
                    flag=true;
                    break;
                }else if(curr_Product*A[r]<K){
                    curr_Product*=A[r];
                    r++;
                }else{
                    while(l<=r && curr_Product*A[r]>K){
                        curr_Product/=A[l];
                        l++;
                    }
                    l++;
                    if(curr_Product*A[r]==K){
                        break;
                    }else{
                        r++;
                    }
                }
            }
            if(flag){
                for(int i=l;i<=r;i++){
                    System.out.print(A[i]+" ");
                }
                System.out.println();
            }else{
                System.out.println(-1);
            }
        }
    }
}
