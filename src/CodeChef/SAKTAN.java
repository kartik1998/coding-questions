package CodeChef;

import java.util.HashMap;
import java.util.Scanner;

public class SAKTAN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt(),M=sc.nextInt(),Q=sc.nextInt();
            HashMap<Integer,Integer> Col = new HashMap<>();
            HashMap<Integer,Integer> Row = new HashMap<>();
            while(Q-->0){
                int X=sc.nextInt()-1;
                int Y=sc.nextInt()-1;
                Col.put(Y,Col.getOrDefault(Y,0)+1);
                Row.put(X,Row.getOrDefault(X,0)+1);
            }
            int count=0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    int sum=Col.get(i)+Row.get(j);
                    if(sum%2!=0){
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
