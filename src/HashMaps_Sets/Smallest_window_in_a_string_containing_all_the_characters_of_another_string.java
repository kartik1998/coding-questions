package HashMaps_Sets;

import java.util.*;
import java.lang.*;
/*
     Code :
     Initialize HashMap for String T
     Initialize start = 0 , end = 0 , count = T.length() , minLength = S.length+1, minLeft = 0
     while( end < S.length ) {
        char ch = S.charAt(end);
        if(map.containsKey(ch)){
            map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0){
                    count--;
                }
            while(count==0){
                if(end-start+1<minLength){
                    minLength = end-start+1;
                    minLeft = start;
                }
                ch = S.charAt(start);
                if(map.containsKey(ch)){
                    map.put(ch.map.get(ch)+1);
                        if(map.get(ch)>0){
                            count++;
                        }
                }
                start++;
            }
            end++;
        }
        String ans = S.substring(minLeft,minLeft+minLength);
     }
 */
public class Smallest_window_in_a_string_containing_all_the_characters_of_another_string {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String S=sc.next();
            String T=sc.next();
            int l = 0, r = 0 , count = T.length();
            String ans= "";
            HashMap<Character,Integer> map = new HashMap<>();
            for(int i=0;i<T.length();i++){
                char ch = T.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
            }
            while(r<S.length()){
                char ch=S.charAt(r);
                if(map.containsKey(ch)){
                    map.put(ch,map.get(ch)-1);
                    if(map.get(ch)>=0){
                        count--;
                    }
                    while(count==0){
                        if(ans.equals("") || ans.length()>r-l+1){
                            ans=S.substring(l,r+1);
                        }
                        ch=S.charAt(l);
                        if(map.containsKey(ch)){
                            map.put(ch,map.get(ch)+1);
                            if(map.get(ch)>0){
                                count++;
                            }
                        }
                        l++;
                    }
                }
                r++;
            }
            System.out.println(ans);
        }
    }
}