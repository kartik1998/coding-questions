package Dynamic_Programming;

import java.util.Scanner;

public class Counting_Bits {
    public static int[] countBits(int N) {
        int A[]=new int[N+1];
        for(int i=0;i<=N;i++){
            int u=i;
            int count=0;
            while(u>0){
                count+=u&1;
                u>>=1;
            }
            A[i]=count;
        }
        return A;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            System.out.println(countBits(sc.nextInt()));
        }
    }
}
