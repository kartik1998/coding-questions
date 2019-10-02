package CodeChef;

import java.util.Scanner;

public class CATFEED {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt(),M=sc.nextInt();
            int A[]=new int[M];
            for(int i=0;i<M;i++){
                A[i]=sc.nextInt();
            }
            int C[]=new int[N];
            boolean flag=true;
            for(int i=0;i<M;i++){
                int x=A[i];
                C[x-1]++;
                for(int j=0;j<N;j++){
                    if(C[x-1]>C[j]+1){
                        flag=false;
                        break;
                    }
                }
            }
            if(flag){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
