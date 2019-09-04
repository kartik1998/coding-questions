package Geeks_For_Geeks_Important;

import java.math.BigInteger;
import java.util.Scanner;

// Input S N M
// Evaluate pow((pow(S,n)%10),m)%1000000007;
public class Evaluate_ {
    public static long pow(long S,int n,int mod){
        long ans=1;
        for(int i=0;i<n;i++){
            ans=(ans%mod*S%mod)%mod;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S=sc.nextInt(),n=sc.nextInt(),m=sc.nextInt();
        long ans=pow(pow(S,n,10),m,1000000007);
        BigInteger bg = ((BigInteger.valueOf(S).pow(n).mod(new BigInteger("10"))).pow(m)).mod(new BigInteger("1000000007"));

        System.out.println(ans);
        System.out.println(bg);
    }
}
// 2,147,483, 647