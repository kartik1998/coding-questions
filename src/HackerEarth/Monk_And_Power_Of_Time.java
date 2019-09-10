package HackerEarth;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Monk_And_Power_Of_Time {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        Queue<Integer> A = new LinkedList<>();
        Queue<Integer> B = new LinkedList<>();
        for(int i=0;i<N;i++){
            A.add(sc.nextInt());
        }
        for(int i=0;i<N;i++){
            B.add(sc.nextInt());
        }
        int count=0;
        while(!A.isEmpty() && !B.isEmpty()){
            if(A.peek()==B.peek()){
                A.remove();
                B.remove();
                count++;
            }else{
                count++;
                A.add(A.remove());
            }
        }
        System.out.println(count);
    }
}
