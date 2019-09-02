package Geeks_For_Geeks_Important;

import java.util.HashSet;
import java.util.Scanner;

public class Find_minimum_shift_for_longest_common_prefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String S=sc.next();
            String T=sc.next();
            int l=T.length();
            T+=T;
            HashSet<String> set = new HashSet<>();
            for(int i=0;i<S.length();i++){
                set.add(S.substring(0,i+1));
            }
            int index=-1;
            int max_l=0;
            for(int i=0;i<l;i++){
                if(T.charAt(i)==S.charAt(0)){
                    int j=i+1;
                    while(set.contains(T.substring(i,j))){
                        j++;
                    }
                    if(j-i-1>max_l){
                        max_l=j-i-1;
                        index=i;
                    }
                }
            }
            System.out.println(Math.min(l-index,index));
        }
    }
}
