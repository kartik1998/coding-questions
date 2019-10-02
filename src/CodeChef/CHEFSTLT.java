package CodeChef;

import java.util.Scanner;

public class CHEFSTLT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String S=sc.next();
            String T=sc.next();
            int min=0,max=0;
            for(int i=0;i<S.length();i++){
                char a=S.charAt(i);
                char b=T.charAt(i);
                if(a!='?' && b!='?' && a!=b){
                    min++;
                    max++;
                }else if(a=='?' || b=='?'){
                    max++;
                }
            }
            System.out.println(min+" "+max);
        }
    }
}
