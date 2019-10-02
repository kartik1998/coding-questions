package LeetCode;

import java.math.BigInteger;
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        BigInteger fact[]=new BigInteger[n+1];
        fact[0]=fact[1]=new BigInteger("1");
        for(int i=2;i<=n;i++){
            fact[i]=fact[i-1].multiply(BigInteger.valueOf(i));
        }

        for(BigInteger i:fact){
            System.out.print(i+" ");
        }
    }
}
