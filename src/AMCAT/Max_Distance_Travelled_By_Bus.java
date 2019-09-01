package AMCAT;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
//You are given n buses and their start and end points of their routes.The routes were on a straight line.
// You need to replace 2 buses with a new bus if their routes overlap and the replaced bus will cover the
// routes of both bus. At the end there should be no overlap . Find the max distance travelled by a bus after
// replacement of overlapping buses.

// Use merge interval technique
public class Max_Distance_Travelled_By_Bus {
    static class Pair implements Comparable<Pair>{
        int x,y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
        @Override
        public int compareTo(Pair o) {
            return this.x-o.x;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        Pair A[]=new Pair[n];
        for(int i=0;i<n;i++){
            A[i]=new Pair(sc.nextInt(),sc.nextInt());
        }
        Arrays.sort(A);
        Stack<Pair> s = new Stack<>();
        for(int i=0;i<n;i++){
            if(s.isEmpty()){
                s.push(A[i]);
            }else{
                if(A[i].x>s.peek().y){
                    s.push(A[i]);
                }else{
                    Pair p=s.pop();
                    s.push(new Pair(p.x,Math.max(p.y,A[i].y)));
                }
            }
        }
        int d=0;
        while(!s.isEmpty()){
            Pair p=s.pop();
            d=Math.max(d,p.y-p.x);
        }
        System.out.println(d);

    }
}
