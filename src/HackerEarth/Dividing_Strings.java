package HackerEarth;

import java.util.HashSet;
import java.util.Scanner;

public class Dividing_Strings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            set.add(ch);
        }
        System.out.println(set.size());
    }
}
