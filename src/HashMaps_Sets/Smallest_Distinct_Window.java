package HashMaps_Sets;
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

public class Smallest_Distinct_Window {
    public static boolean check(char s[],int l,int r,HashSet<Character> h){
        HashSet<Character> set=new HashSet<>(h);
        for(int i=l;i<=r;i++){
            if(set.contains(s[i])){
                set.remove(s[i]);
            }
        }
        if(set.size()==0){
            return true;
        }
        return false;
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            char s[]=sc.next().toCharArray();
            HashSet<Character> set=new HashSet<>();
            for(int i=0;i<s.length;i++){
                set.add(s[i]);
            }
            int l=0;
            int r=0;
            int min=Integer.MAX_VALUE;
            while(r<s.length){
                if(check(s,l,r,set)){
                    while(l<=r && check(s,l,r,set)){
                        l++;
                    }
                    min=Math.min(min,r-l+1);
                }
                r++;
            }
            System.out.println(min+1);

        }

    }
}