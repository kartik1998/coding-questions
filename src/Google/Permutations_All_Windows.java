package Google;

import java.util.HashSet;
import java.util.Scanner;

public class Permutations_All_Windows {
    static HashSet<String> set = new HashSet<>();
    public static void permutations(String input,String output){
        if(input.length()==0){
            if(!set.contains(output)) {
                System.out.print(output + " ");
                set.add(output);
            }
            return;
        }
        for(int i=0;i<input.length();i++){
            permutations(input.substring(0,i)+input.substring(i+1),output+input.charAt(i));
        }
    }
    public static void possibleSequences(String str){
        int k=1;
        while(k<=str.length()) {
            for (int i = 0; i < str.length(); i++) {
                if(i+k<=str.length()){
                    permutations(str.substring(i,i+k),"");
                }
            }
            k++;
        }
        set.clear();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        possibleSequences(str);
    }
}
