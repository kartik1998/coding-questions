package CodeChef;

import java.util.Arrays;
import java.util.Scanner;

public class CHFAR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int A[]=new int[n];
            int K=sc.nextInt();
            int LHS=0;
            int RHS=0;
            for(int i=0;i<n;i++){
                A[i]=sc.nextInt();
                LHS+=A[i]*A[i];
                RHS+=A[i];
            }
            Arrays.sort(A);
            boolean flag=false;
            for(int i=n-1;i>=0 && K>0;i--,K--){
                LHS-=A[i]*A[i];
                RHS-=A[i];
                if(LHS<=RHS){
                    flag=true;
                    break;
                }
            }
            if(flag || LHS<=RHS){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
