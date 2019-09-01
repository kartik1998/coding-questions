package AMCAT;

import java.util.Scanner;

// You are given a string consisting of only 0 and 1. You can replace at most k 0’s in the string with 1.
// Find no of ways to obtain maximum length of consecutive 1’s in the string.
public class flip_bits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt() , k=sc.nextInt();
        int c=k;
        char s[]=sc.next().toCharArray();
        int l=0,r=0;
        int W=0;
        while(r<n){
            if(s[r]=='0'){
                k--;
                if(k<0){
                    while(l<=r && s[l]!='0'){
                        l++;
                    }
                    l++;
                }
            }
            W=Math.max(r-l+1,W);
            r++;
        }
        k=c;
        int count=0;
        for(int i=0;i<W;i++){
            if(s[i]=='0'){
                count++;
            }
        }
        int ans=0;
        if(count==k){
            ans++;
        }
        for(int i=W;i<n;i++){
            if(s[i]=='0'){
                count++;
            }
            if(s[i-W]=='0'){
                count--;
            }
            if(count==k){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
