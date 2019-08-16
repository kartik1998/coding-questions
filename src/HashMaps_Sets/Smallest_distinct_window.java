package HashMaps_Sets;

import java.util.HashMap;
import java.util.Scanner;

public class Smallest_distinct_window {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String S=sc.next();
            HashMap<Character,Integer> map = new HashMap<>();
            for(int i=0;i<S.length();i++){
                map.put(S.charAt(i),1);
            }
            int l=0,r=0,count=map.size();
            String ans="";
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
                        ch = S.charAt(l);
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
