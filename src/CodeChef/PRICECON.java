package CodeChef;

import java.util.Scanner;

public class PRICECON {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt() , k=sc.nextInt() ,res=0;
            for(int i=0;i<n;i++){
                int Pi=sc.nextInt();
                res+=Math.max(0,Pi-k);
            }
            System.out.println(res);
        }
    }
}
