package Geeks_For_Geeks_Important;
import java.lang.*;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Smallest_Window_In_A_String_Containing_All_Characters_Of_Another_String{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String S=sc.next();
            String T=sc.next();
            int l=0,r=0,count=T.length();
            String ans="";
            HashMap<Character,Integer> map = new HashMap<>();
            for(int i=0;i<T.length();i++){
                char ch=T.charAt(i);
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
            if(ans.equals("")){
                System.out.println(-1);
            }else{
                System.out.println(ans);
            }
        }
    }
}