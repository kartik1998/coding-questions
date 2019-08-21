package Geeks_For_Geeks_Important;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
// (A1 A2 A3 A4 . . . . Ai) - We need Ai hence for this we use Max Heap
// (Ai+1,Ai+2, . . . Ak) - We need Ai+1 hence for this we use Min Heap
public class Find_Median_In_A_Stream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> Max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> Min = new PriorityQueue<>();
        int n=sc.nextInt();
        while(n-->0){
            int x=sc.nextInt();
            if(Max.isEmpty()){
                Max.add(x);
            }else{
                if(x<=Max.peek()){
                    Max.add(x);
                    if(Max.size()-Min.size()==2){
                        Min.add(Max.remove());
                    }
                }else{
                    Min.add(x);
                    if(Min.size()-Max.size()==2){
                        Max.add(Min.remove());
                    }
                }
            }
            if(Max.size()>Min.size()){
                System.out.println(Max.peek());
            }else if(Min.size()>Max.size()){
                System.out.println(Min.peek());
            }else{
                int ans=(Max.peek()+Min.peek())/2;
                System.out.println(ans);
            }
        }
    }
}
