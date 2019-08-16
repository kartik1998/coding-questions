package HashMaps_Sets;

import java.util.HashSet;
import java.util.Scanner;

// Solve in O(n) time
public class Check_If_Given_Sequence_Is_In_AP {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int A[]=new int[n];
            HashSet<Integer> set = new HashSet<>();
            int min=Integer.MAX_VALUE;
            int max= Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                A[i]=sc.nextInt();
                set.add(A[i]);
                min=Math.min(A[i],min);
                max=Math.max(A[i],max);
            }
            int d=(max-min)/(n-1);
            boolean flag=true;
            for(int i=0;i<n;i++){
                if(!set.contains(min+d*i)){
                    flag=false;
                    break;
                }
            }
            if(flag){
                System.out.println("Yes the sequence is in AP");
                System.out.println("Constant Difference is "+d);
            }else{
                System.out.println("No the sequence isn't in AP");
            }

        }
    }
}
