package HashMaps_Sets;

import java.util.Scanner;

public class Find_Subarray_With_Given_Sum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int A[]=new int[n];
            for(int i=0;i<n;i++){
                A[i]=sc.nextInt();
            }
            int target=sc.nextInt();
            int curr_sum=0;
            int r=0;
            int l=0;
            boolean flag=false;
            while(r<A.length){
                if(curr_sum+A[r]==target){
                    flag=true;
                    break;
                }else if(curr_sum+A[r]<target){
                    curr_sum+=A[r];
                    r++;
                }else{
                    curr_sum-=A[l];
                    l++;
                    if(l>r){
                        r=l;
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
