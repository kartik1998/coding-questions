package CodeChef;

import java.util.Scanner;

public class ALLSUB {
    public static boolean checkContains(String S,String T){
        int dp[]=new int[26];
        for(int i=0;i<T.length();i++){
            dp[T.charAt(i)-'a']++;
        }
        for(int i=0;i<S.length();i++){
            dp[S.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(dp[i]>0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String T=sc.next();
            String S=sc.next();
            int dT[]=new int[26];
            for(int i=0;i<T.length();i++){
                dT[T.charAt(i)-'a']++;
            }
            int dS[]=new int[26];
            for(int i=0;i<S.length();i++){
                dS[S.charAt(i)-'a']++;
            }
            for(int i=0;i<26;i++){
                dS[i]-=dT[i];
            }
            char ch=T.charAt(0);
            boolean flag=false;
            if(checkContains(S,T)){
                String ans="";
                for(int i=0;i<26;i++){
                    int x=dS[i];
                    while(x-->0) {
                        ans += (char) (i + 'a');
                    }
                }
                int ind=ans.length();
                for(int i=0;i<ans.length();i++){
                    char c=ans.charAt(i);
                    if(ch<c){
                        ind=i;
                        break;
                    }
                }
                ans=ans.substring(0,ind)+T+ans.substring(ind);
                System.out.println(ans);
            }else{
                System.out.println("Impossible");
            }
        }
    }
}
