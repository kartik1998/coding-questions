package Stacks_And_Queues;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class First_non_repeating_character_in_a_stream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            HashMap<Character,Boolean> map = new HashMap<>();
            Queue<Character> q = new LinkedList<>();
            int n = sc.nextInt();
            while(n-->0){
                char ch=sc.next().charAt(0);
                if(!map.containsKey(ch)){
                    map.put(ch,true);
                    q.add(ch);
                    System.out.print(q.peek()+" ");
                }else{
                    map.put(ch,false);
                    while(!q.isEmpty() && map.get(q.peek())==false){
                        q.remove();
                    }
                    if(q.isEmpty()){
                        System.out.print("-1 ");
                    }else{
                        System.out.print(q.peek()+" ");
                    }
                }
            }
            System.out.println();
        }
    }
}
