package CodeForces.Five_Ninety_Eight;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            long a=sc.nextLong(),b=sc.nextLong(),n=sc.nextLong(),S=sc.nextLong();
            if(b>=S%n && a*n+b>=S){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
