package Dynamic_Programming;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Building_Bridges_problem {
    static class Pair {
        int x,y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int X_coordinates[]=new int[n];
            int Y_coordinates[]=new int[n];
            for(int i=0;i<n;i++){
                X_coordinates[i]=sc.nextInt();
            }
            for(int i=0;i<n;i++){
                Y_coordinates[i]=sc.nextInt();
            }
            Pair A[]=new Pair[n];
            for(int i=0;i<n;i++){
                A[i]=new Pair(X_coordinates[i],Y_coordinates[i]);
            }
            Arrays.sort(A,new Comparator<Pair>(){
                    @Override
                    public int compare(Pair p1,Pair p2){
                        return p1.y-p2.y;
                    }
            });
            int dp[]=new int[n];
            dp[0]=1;
            int LIS=0;
            for(int i=1;i<n;i++){
                dp[i]=1;
                for(int j=i-1;j>=0;j--){
                    if(A[i].x>A[j].x){
                        dp[i]=Math.max(dp[i],dp[j]+1);
                    }
                }
                LIS=Math.max(LIS,dp[i]);
            }
            for(int i=0;i<A.length;i++){
                System.out.print(A[i].x+" ");
            }
            System.out.println();
            for(int j=0;j<A.length;j++){
                System.out.print(A[j].y+" ");
            }
            System.out.println();
            System.out.println(LIS);
        }
    }
}
