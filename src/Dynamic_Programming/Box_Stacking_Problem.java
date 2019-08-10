package Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;
class Triple implements Comparable<Triple>{
    int h,w,l;
    Triple(int h,int w,int l){
        this.h=h;
        this.w=w;
        this.l=l;
    }
    public int compareTo(Triple p){
        int a=this.w*this.l;
        int b=p.w*p.l;
        return b-a;
    }
}
public class Box_Stacking_Problem {
    public static int maxHeight(int height[],int width[],int length[],int n){
        Triple A[]=new Triple[3*n];
        int k=0;
        for(int i=0;i<n;i++){
            int h=height[i];
            int w=width[i];
            int l=length[i];
            A[k++]=new Triple(h,Math.max(w,l),Math.min(w,l));
            A[k++]=new Triple(w,Math.max(l,h),Math.min(l,h));
            A[k++]=new Triple(l,Math.max(h,w),Math.min(h,w));
        }
        Arrays.sort(A);
        int dp[]=new int[3*n];
        dp[0]=A[0].h;
        int max=A[0].h;
        for(int i=1;i<3*n;i++){
            dp[i]=A[i].h;
            for(int j=i-1;j>=0;j--){
                if(A[j].l>A[i].l && A[j].w>A[i].w){
                    dp[i]=Math.max(dp[i],dp[j]+A[i].h);
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int height[]=new int[n];
            int width[]=new int[n];
            int length[]=new int[n];
            for(int i=0;i<n;i++){
                height[i]=sc.nextInt();
            }
            for(int i=0;i<n;i++){
                width[i]=sc.nextInt();
            }
            for(int i=0;i<n;i++){
                length[i]=sc.nextInt();
            }
            System.out.println(maxHeight(height,width,length,n));
        }
    }
}
