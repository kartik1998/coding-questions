package CodeChef;

import java.util.Scanner;

public class CRDGAME {
    public static int sum(int x){
        int u = x;
        int res=0;
        while(u>0){
            res+=u%10;
            u/=10;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int a = 0 ,b=0;
            int n = sc.nextInt();
            while(n-->0){
                int x = sc.nextInt() , y=sc.nextInt();
                if(sum(x)>sum(y)){
                    a++;
                }else if(sum(y)>sum(x)){
                    b++;
                }else{
                    a++;
                    b++;
                }
            }
            if(a>b){
                System.out.println("0 "+a);
            }else if(b>a){
                System.out.println("1 "+b);
            }else{
                System.out.println("2 "+a);
            }
        }
    }
}
