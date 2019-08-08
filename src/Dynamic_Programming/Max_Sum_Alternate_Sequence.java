package Dynamic_Programming;

import java.util.Scanner;

public class Max_Sum_Alternate_Sequence {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int A[]=new int[n];
            for(int i=0;i<n;i++){
                A[i]=sc.nextInt();
            }
            int inc[]=new int[n];
            int dec[]=new int[n];
            inc[0]=dec[0]=A[0];
            boolean flag=false;
            for(int i=1;i<n;i++){
                for(int j=i-1;j>=0;j--){
                    if(A[i]<A[j]){
                        dec[i]=Math.max(dec[i],inc[j]+A[i]);
                        flag=true;
                    }else if(flag && A[i]>A[j]){
                        inc[i]=Math.max(inc[i],dec[j]+A[i]);
                    }
                }
            }
            int max=0;
            for(int i=0;i<inc.length;i++){
                max=Math.max(max,Math.max(inc[i],dec[i]));
            }
            System.out.println(max);
        }
    }
}
