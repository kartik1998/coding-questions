package HashMaps_Sets;

import java.util.HashSet;
import java.util.Scanner;
// Code Probably Wrong
public class Count_number_of_substrings_with_K_distinct_Characters {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            char s[]=sc.next().toCharArray();
            HashSet<Character> set=new HashSet<>();
            int k=sc.nextInt();
            int l=0;
            int r=0;
            int count=0;
            while(r<s.length){
                if(set.contains(s[r])){
                    if(set.size()==k){
                        count++;
                    }
                    r++;
                }else{
                    if(set.size()<k){
                        set.add(s[r]);
                        if(set.size()==k){
                            count++;
                        }
                        r++;
                    }else{
                        char ch=s[l];
                        while(s[l]==ch){
                            l++;
                        }
                        set.remove(ch);
                    }
                }
            }
            char ch=s[l];
            if(set.size()==k) {
                while (l < r && s[l] == ch) {
                    count++;
                    l++;
                }
            }
            System.out.println(count);
        }
    }
}
