package Geeks_For_Geeks_Miscellanous;

import java.util.Scanner;

//Given a binary string, that is it contains only 0s and 1s.
// We need to make this string a sequence of alternate characters by flipping some of the bits,
// our goal is to minimize the number of bits to be flipped.
public class MIn_Number_Of_Flips {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String s=sc.next();
            int a=0;
            int b=0;
            for(int i=0;i<s.length();i++){
                if(i%2==0){
                    // a -> 0 b -> 1
                    if(s.charAt(i)=='0'){
                        b++;
                    }else{
                        a++;
                    }
                }else{
                    // a - > 1 b - > 0
                    if(s.charAt(i)=='0'){
                        a++;
                    }else{
                        b++;
                    }
                }
            }
            System.out.println(Math.min(a,b));
        }
    }
}
