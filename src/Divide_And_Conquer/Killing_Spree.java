package Divide_And_Conquer;
// https://practice.geeksforgeeks.org/problems/killing-spree/0/?ref=self
import java.util.Scanner;

public class Killing_Spree {
    public static boolean check(long mid,long P){
        if((mid+1)*(2*mid+1)<=P*6/mid){
            return true;
        }
        return false;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            long P=sc.nextLong();
            long ans=-1;
            long s=0,e=P;
            while(s<=e){
                long mid=(s+e)/2;
                if(check(mid,P)){
                    ans=mid;
                    s=mid+1;
                }else{
                    e=mid-1;
                }
            }
            System.out.println(ans);
        }
    }
}
