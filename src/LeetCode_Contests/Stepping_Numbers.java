package LeetCode_Contests;
import java.util.*;

public class Stepping_Numbers {
    public static List<Integer> countSteppingNumbers(int low, int high) {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<=9;i++){
            q.add(i);
        }
        while(!q.isEmpty()){
            int x=q.remove();
            if(x>=low && x<=high){
                res.add(x);
            }
            if(x==0 || x>high){
                if(x>high){
                    break;
                }
                continue;
            }
            int last=x%10;
            int A=10*x+(last+1);
            int B=10*x+(last-1);
            if(last==0){
                q.add(A);
            }else if(last==9){
                q.add(B);
            }else{
                q.add(B);
                q.add(A);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int low=sc.nextInt(),high=sc.nextInt();
            List<Integer> a = countSteppingNumbers(low,high);
            for(int i: a){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

