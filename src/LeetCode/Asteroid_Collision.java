package LeetCode;

import java.util.Stack;

public class Asteroid_Collision {
    public static int[] asteroidCollision(int[] A) {
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<A.length;i++){
            if(s.isEmpty()){
                s.push(A[i]);
            }else{
                if(A[i]<=0 && s.peek()<=0 || A[i]>=0 && s.peek()>=0){
                    s.push(A[i]);
                }else{
                    int a=Math.abs(A[i]);
                    int b=Math.abs(s.peek());
                    if(a==b){
                        s.pop();
                    }else if(a>b){
                        s.pop();
                        s.push(A[i]);
                    }
                }
            }
        }
        int ans[]=new int[s.size()];
        int k=ans.length-1;
        while(!s.isEmpty()){
            ans[k--]=s.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        int A[]={5,10,-5,-3,-1,3,6,7,10,-20};
        int ans[]=asteroidCollision(A);
        for(int i:ans){
            System.out.print(i+" ");
        }
    }
}
