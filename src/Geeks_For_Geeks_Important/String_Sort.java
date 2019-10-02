package Geeks_For_Geeks_Important;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class String_Sort {
    public static int compared(String a,String b){
        int i=0,j=0;
        for(;i<a.length() && j<b.length();i++,j++){
            int x =a.charAt(i)-'0';
            int y = b.charAt(j)-'0';
            if(x>y){
                return 1;
            }else if(x<y){
                return -1;
            }
        }
        if(i!=a.length()){
            return -1;
        }return 1;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n=0;
        ArrayList<String> a = new ArrayList<>();
        if(sc.hasNext()){
            n=sc.nextInt();
        }
        while(n-->0){
            if(sc.hasNext()){
                a.add(sc.next());
            }
        }
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return compared(o1,o2);
            }
        });
        for(int i=0;i<a.size();i++){
            System.out.println(a.get(i));
        }
    }
}
