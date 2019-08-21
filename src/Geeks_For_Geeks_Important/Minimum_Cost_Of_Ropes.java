package Geeks_For_Geeks_Important;
// There are given N ropes of different lengths, we need to connect these ropes into one rope.
// The cost to connect two ropes is equal to sum of their lengths.
// The task is to connect the ropes with minimum cost.
import java.util.PriorityQueue;
import java.util.Scanner;

public class Minimum_Cost_Of_Ropes {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int A[]=new int[n];
            PriorityQueue<Integer> q = new PriorityQueue<>();
            long sum=0;
            for(int i=0;i<n;i++){
                A[i]=sc.nextInt();
                q.add(A[i]);
            }
            while(q.size()!=1){
                int a=q.remove();
                int b=q.remove();
                sum+=(a+b);
                q.add(a+b);
            }
            System.out.println(sum);
        }
    }
}
