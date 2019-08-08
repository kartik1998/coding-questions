package Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class pair{
    int x,y;
    pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}
public class Snake_And_Ladder {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int i=0;i<n;i++){
                int k=sc.nextInt();
                int v=sc.nextInt();
                map.put(k,v);
            }
            boolean visited[]=new boolean[31];
            int ans=-1;
            Queue<pair> q = new LinkedList<>();
            q.add(new pair(1,0));
            while(!q.isEmpty()){
                pair p=q.remove();
                int x=p.x;
                int y=p.y;
                for(int i=1;i<=6;i++){
                    int X=x+i;
                    if(X<31 && map.containsKey(X)){
                        if(!visited[map.get(X)]){
                            visited[map.get(X)]=true;
                            q.add(new pair(map.get(X),y+1));
                        }
                    }else{
                        if(X<31 && !visited[X]){
                            visited[X]=true;
                            q.add(new pair(X,y+1));
                        }
                    }
                    if(visited[30]){
                        ans=y+1;
                        break;
                    }
                }
                if(ans!=-1){
                    System.out.println(ans);
                    break;
                }
            }

        }
    }
}
