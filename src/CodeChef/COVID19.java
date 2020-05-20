package CodeChef;

import java.util.Scanner;

// Basically find the shortest sequence with difference at most two
// Basically find the longest sequence with difference at most two
public class COVID19 {
    public static void best_worstScenario(int A[]){
        int res_max = 1,res_min=Integer.MAX_VALUE,sub=1;
        for(int i=1;i<A.length;i++){
            if(A[i]-A[i-1]<=2){
                sub++;
                res_max = Math.max(sub,res_max);
            }else{
                res_min = Math.min(res_min,sub);
                sub=1;
            }
        }
        res_min = Math.min(sub,res_min);
        res_max = Math.max(sub,res_max);
        System.out.println(res_min+" "+res_max);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            int n = sc.nextInt();
            int A[] = new int[n];
            for(int i=0;i<n;i++){
                A[i] = sc.nextInt();
            }
            best_worstScenario(A);
        }
    }
}
