package Dynamic_Programming;

import java.util.Scanner;

public class One_Count {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int A[]=new int[n];
        for(int i=0;i<n;i++){
            A[i]=sc.nextInt();
        }
        int r=0;
        int l=0;
        int max=0;
        while(r<n){
            if(A[r]==0){
                k--;
            }
            while(k<0){
                if(A[l]==0){
                    k++;
                }
                l++;
            }
            max=Math.max(max,r-l+1);
            r++;
        }
        System.out.println(max);
        for(int i=0;i<A.length;i++){
            if(i>=l && i<=r){
                System.out.print("1 ");
            }else {
                System.out.print(A[i] + " ");
            }
        }
    }
}
