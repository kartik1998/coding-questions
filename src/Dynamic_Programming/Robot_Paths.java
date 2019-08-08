package Dynamic_Programming;


import java.math.BigInteger;
import java.util.Scanner;

public class Robot_Paths {
    public static boolean isSafe(int x,int y,int n,int m, boolean visited[][]){
        if(x>=0 && x<n && y>=0 && y<m && !visited[x][y]){
            return true;
        }
        return false;
    }
    public static BigInteger helper(int x, int y, int n, int m, boolean visited[][],BigInteger dp[][]){
        if(!isSafe(x,y,n,m,visited)){
            return new BigInteger("0");
        }
        if(dp[x][y]!=null){
            return dp[x][y];
        }
        if(x==n-1 && y==m-1){
            return dp[x][y]=BigInteger.valueOf(1);
        }

        return dp[x][y]=helper(x+1,y,n,m,visited,dp).add(helper(x,y+1,n,m,visited,dp));
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int p=sc.nextInt();
        boolean visited[][]=new boolean[n][m];
        for(int i=0;i<p;i++){
            int x=sc.nextInt()-1;
            int y=sc.nextInt()-1;
            visited[x][y]=true;
        }
        BigInteger mod=new BigInteger("1000000007");
        BigInteger dp[][]=new BigInteger[n+1][m+1];
        System.out.println(helper(0,0,n,m,visited,dp).mod(mod));

    }
}
