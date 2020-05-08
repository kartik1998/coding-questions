package HackerEarth;

import java.util.*;

public class Avoid_traps {
    public static ArrayList<Integer> slidingMax(int A[],int K){
        Deque<Integer> q = new LinkedList<>();
        for(int i=0;i<K;i++){
            while(!q.isEmpty() && A[i]>A[q.peekLast()]){
                q.removeLast();
            }
            q.addLast(i);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=K;i<A.length;i++){
            res.add(q.peekFirst());
            while(!q.isEmpty() && q.peekFirst()<=i-K){
                q.removeFirst();
            }
            while(!q.isEmpty() && A[i]>A[q.peekLast()]){
                q.removeLast();
            }
        }
        res.add(q.peekFirst());
        return res;
    }
    public static int countPrimes(int N) {
        if (N <= 1) {
            return 0;
        }
        boolean sieve[] = new boolean[N + 1];
        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;
        for (int i = 2; i <= N; i++) {
            if (sieve[i]) {
                for (int j = i * i; j <= N; j++) {
                    sieve[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i <= N; i++) {
            if (sieve[i] && N%i==0) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt() , n = sc.nextInt();
        int A[] = new int[n];
        for(int i=0;i<n;i++){
            A[i] = sc.nextInt();
        }
        int primeCount[] = new int[n];
        for(int i=0;i<n;i++){
            primeCount[i] = countPrimes(A[i]);
        }
        ArrayList<Integer> res = slidingMax(primeCount,x);
        int min = Integer.MAX_VALUE;
        for(int i:res){
            min = Math.min(min,A[i]);
        }
        System.out.println(min);
    }
}
