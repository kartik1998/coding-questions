package Dynamic_Programming.KeyBoard_Questions;

import java.util.Scanner;

public class Copy_Paste_KeyBoard {
    public static long helper(int n,int x){
        if(x>n){
            return Integer.MAX_VALUE;
        }
        if(x==n){
            return 0;
        }
        return Math.min(helper(n,2*x),helper(n,x+1))+1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            System.out.println(helper(n,1));
        }
    }
}
