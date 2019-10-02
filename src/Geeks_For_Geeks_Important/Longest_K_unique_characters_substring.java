package Geeks_For_Geeks_Important;

import java.util.HashSet;
import java.util.Scanner;

public class Longest_K_unique_characters_substring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String S=sc.next();
            int K=sc.nextInt();
            HashSet<Character> set = new HashSet<>();
            int l=0,r=0;
            int max=-1;
            while(r<S.length()){
                char ch=S.charAt(r);
                if(set.contains(ch)){
                    if(set.size()==K){
                        max=Math.max(max,r-l+1);
                    }
                }else{
                    set.add(ch);
                    if(set.size()==K){
                        max=Math.max(max,r-l+1);
                    }else if(set.size()>K){
                        l=r;
                        set.clear();
                    }
                }
                r++;
            }
            System.out.println(max);
        }
    }
}
