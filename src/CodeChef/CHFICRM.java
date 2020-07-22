package CodeChef;

import java.util.Scanner;

public class CHFICRM {
    public static boolean validChange(int A[]){
        int five=0,ten=0;
        for(int i=0;i<A.length;i++){
            if(A[i]==5){
                five++;
            }else if(A[i]==10){
                if(five>0){
                    five--;
                    ten++;
                }else{
                    return false;
                }
            }else{
                if(ten>0){
                    ten--;
                }else if(five>1){
                    five-=2;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int A[] = new int[n];
            for(int i=0;i<n;i++){
                A[i] = sc.nextInt();
            }
            if(validChange(A)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
