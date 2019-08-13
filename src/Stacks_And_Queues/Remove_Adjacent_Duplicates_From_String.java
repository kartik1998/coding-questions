package Stacks_And_Queues;

import java.util.Scanner;
import java.util.Stack;

public class Remove_Adjacent_Duplicates_From_String {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            char ch[]=sc.next().toCharArray();
            Stack<Character> s=new Stack<>();
            for(int i=0;i<ch.length;){
                if(s.isEmpty()){
                    s.push(ch[i]);
                    i++;
                }else{
                    if(s.peek()==ch[i]){
                        while(i<ch.length && ch[i]==s.peek()){
                            i++;
                        }
                        s.pop();
                    }else{
                        s.push(ch[i]);
                        i++;
                    }
                }
            }
            String ans="";
            while(!s.isEmpty()){
                ans=s.pop()+ans;
            }
            System.out.println(ans);
        }
    }
}
