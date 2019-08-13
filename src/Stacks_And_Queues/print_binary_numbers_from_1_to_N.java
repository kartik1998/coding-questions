package Stacks_And_Queues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class print_binary_numbers_from_1_to_N {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            Queue<String> q=new LinkedList<>();
            q.add("1");
            while(n-->0){
                String s=q.remove();
                System.out.print(s+" ");
                q.add(s+"0");
                q.add(s+"1");
            }
            System.out.println();
        }
    }
}
