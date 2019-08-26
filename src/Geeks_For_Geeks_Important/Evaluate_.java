package Geeks_For_Geeks_Important;

import java.math.BigInteger;
import java.util.Scanner;

// Input S N M
// Evaluate pow((pow(S,n)%10),m)%1000000007;
public class Evaluate_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S=sc.next(),N=sc.next(),M=sc.next();
        BigInteger bg = new BigInteger(S);
        bg=bg.pow(Integer.parseInt(N));
        bg=bg.mod(new BigInteger("10"));
        bg=bg.pow(Integer.parseInt(M));
        bg=bg.mod(new BigInteger("1000000007"));
        System.out.println(bg);
    }
}
