package Dynamic_Programming.Catalan_Number_Problems;

import java.util.Scanner;

// Given number of nodes Calculate the amount of BSTs that you can create :
// Catalan Number used.
public class Number_Of_BSTs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            long fact[]=new long[2*n+1];
            fact[0]=1;
            fact[1]=1;
            for(int i=2;i<=2*n;i++){
                fact[i]=(long)i*fact[i-1];
            }
            long numerator=fact[2*n];
            long denominator=fact[n]*fact[n+1];
            System.out.println(numerator/denominator);
        }
    }
}
