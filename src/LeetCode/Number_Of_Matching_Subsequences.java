package LeetCode;

import java.util.HashSet;

public class Number_Of_Matching_Subsequences {
    public boolean check(String S,String T,int n,int m){
        if(n==0){
            return true;
        }
        if(m==0){
            return false;
        }
        if(S.charAt(n-1)==T.charAt(m-1)){
            return check(S,T,n-1,m-1);
        }else{
            return check(S,T,n,m-1);
        }
    }
    public boolean isSubsequence(String S, String T) {
        return check(S,T,S.length(),T.length());
    }
    public int numMatchingSubseq(String S, String[] W) {
        int count=0;
        HashSet<String> T = new HashSet<>();
        HashSet<String> set = new HashSet<>();
        for(String str : W){
            if(!set.contains(str)){
                if(T.contains(str)){
                    count++;
                    continue;
                }
                if(isSubsequence(str,S)){
                    count++;
                    T.add(str);
                }else{
                    set.add(str);
                }
            }
        }
        return count;
    }
}
