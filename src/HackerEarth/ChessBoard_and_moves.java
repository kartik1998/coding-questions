package HackerEarth;

import java.util.Scanner;

public class ChessBoard_and_moves {
    public static int rookMoves(char A[][],int x,int y,int n,int m){
        int count = 0;
        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};
        for(int i=0;i<4;i++){
            int X = x+dx[i];
            int Y = y+dy[i];
            while(true){
                if(X>=0 && X<n && Y>=0 && Y<m && A[X][Y]=='.'){
                    count++;
                    X +=dx[i];
                    Y +=dy[i];
                }else{
                    break;
                }
            }
        }
        return count;
    }
    public static int bishopMoves(char A[][],int x,int y,int n,int m){
        int count = 0;
        int dx[] = {1,1,-1,-1};
        int dy[] = {1,-1,1,-1};
        for(int i=0;i<4;i++){
            int X = x+dx[i];
            int Y = y+dy[i];
            while(true){
                if(X>=0 && X<n && Y>=0 && Y<m && A[X][Y]=='.'){
                    count++;
                    X +=dx[i];
                    Y +=dy[i];
                }else{
                    break;
                }
            }
        }
        return count;
    }
    public static int queenMoves(char A[][],int x,int y,int n,int m){
        int count = 0;
        int dx[] = {1,1,-1,-1,0,0,-1,1};
        int dy[] = {1,-1,1,-1,1,-1,0,0};
        for(int i=0;i<8;i++){
            int X = x+dx[i];
            int Y = y+dy[i];
            while(true){
                if(X>=0 && X<n && Y>=0 && Y<m && A[X][Y]=='.'){
                    count++;
                    X +=dx[i];
                    Y +=dy[i];
                }else{
                    break;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt() , M = sc.nextInt();
        char A[][] = new char[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                A[i][j] = sc.next().charAt(0);
            }
        }
        int count = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(A[i][j]=='B'){
                    count += bishopMoves(A,i,j,N,M);
                }else if(A[i][j]=='R'){
                    count += rookMoves(A,i,j,N,M);
                }else if(A[i][j]=='Q'){
                    count +=queenMoves(A,i,j,N,M);
                }
            }
        }
        System.out.println(count);
    }
}
