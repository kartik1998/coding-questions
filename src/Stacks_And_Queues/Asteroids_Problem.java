package Stacks_And_Queues;

import java.util.Scanner;
import java.util.Stack;

public class Asteroids_Problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int A[]=new int[n];
            for(int i=0;i<n;i++){
                A[i]=sc.nextInt();
            }
            Stack<Integer> s = new Stack<>();
            for(int i=0;i<A.length;i++){
                if(s.isEmpty()){
                    s.push(A[i]);
                }else{
                    boolean flag=false;
                    while(!s.isEmpty() && s.peek()*A[i]<0 && Math.abs(A[i])>=Math.abs(s.peek())){
                        s.pop();
                        flag=true;
                    }
                    if(!flag){
                        s.push(A[i]);
                    }else if(s.isEmpty() || s.peek()*A[i]>=0){
                        s.push(A[i]);
                    }
                }
            }
            String ans="";
            while(!s.isEmpty()){
                ans=String.valueOf(s.pop())+" "+ans;
            }
            System.out.println(ans);
        }
    }
}
