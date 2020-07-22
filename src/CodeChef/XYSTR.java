package CodeChef;

import java.util.Scanner;

public class XYSTR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String str = sc.next();
            int res = 0;
            for(int i=0;i<str.length()-1;){
                if(str.charAt(i)!=str.charAt(i+1)){
                    res++;
                    i+=2;
                }else{
                    i++;
                }
            }
            System.out.println(res);
        }
    }
}
