package HackerEarth;

import java.util.*;
public class Factorial {
    public static long fact(long x,long mod){
        long ans = 1;
        while(x>=1){
            ans=(ans*x);
            x--;
        }
        return ans%mod;
    }
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int N = sc.nextInt();
            int M = sc.nextInt();
            long mod = (long)Math.pow(10,M);
            System.out.println(fact(fact(N,mod),mod));
        }
    }
}

