package LeetCode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class LRUCache {
    int K;
    HashMap<Integer,Integer> map = new HashMap<>();
    Deque<Integer> q = new LinkedList<>();
    public LRUCache(int capacity) {
        this.K=capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            update(key);
            return map.get(key);
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(q.size()<K){
            if(map.containsKey(key)){
                update(key);
                map.put(key,value);
            }else{
                map.put(key,value);
                q.addFirst(key);
            }
        }else{
            int x = q.removeLast();
            map.remove(x);
        }
    }

    public void update(int key){
        Stack<Integer> s = new Stack<>();
        while(q.peekLast()!=key){
            s.push(q.removeLast());
        }
        q.addFirst(q.removeLast());
        while(!s.isEmpty()){
            q.addLast(s.pop());
        }
    }
}