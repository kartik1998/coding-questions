package Stacks_And_Queues;

import java.util.Scanner;
import java.util.Stack;

public class Longest_Valid_Parenthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String str=sc.next();
            Stack<Integer> s = new Stack<>();
            s.push(-1);
            int max=0;
            for(int i=0;i<str.length();i++){
                char ch=str.charAt(i);
                if(ch=='('){
                    s.push(i);
                }else{
                    s.pop();
                    if(s.isEmpty()){
                        s.push(i);
                    }
                    max=Math.max(max,i-s.peek());
                }
            }
            System.out.println(max);
        }
    }
}
