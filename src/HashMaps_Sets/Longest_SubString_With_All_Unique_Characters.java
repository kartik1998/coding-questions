package HashMaps_Sets;

import java.util.HashSet;
import java.util.Scanner;

public class Longest_SubString_With_All_Unique_Characters {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            char s[]=sc.next().toCharArray();
            HashSet<Character> set=new HashSet<>();
            int l=0;
            int r=0;
            int max=0;
            while(r<s.length){
                if(set.contains(s[r])){
                    while(s[l]!=s[r]){
                        set.remove(s[l]);
                        l++;
                    }
                    set.remove(s[l]);
                    l++;
                }else {
                    max=Math.max(max,r-l+1);
                }
                set.add(s[r]);
                r++;
            }
            System.out.println(max);
        }
    }
}
