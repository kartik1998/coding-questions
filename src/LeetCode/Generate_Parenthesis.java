package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Generate_Parenthesis {
    static class Solution {
        HashSet<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        public boolean check(String str){
            Stack<Character> s = new Stack<>();
            for(int i=0;i<str.length();i++){
                char ch=str.charAt(i);
                if(s.isEmpty()){
                    if(ch==')'){
                        return false;
                    }else{
                        s.push(ch);
                    }
                }else{
                    if(ch==')'){
                        s.pop();
                    }else{
                        s.push(ch);
                    }
                }
            }
            if(s.isEmpty()){
                return true;
            }
            return false;
        }
        public List<String> generateParenthesis(int n) {
            helper(2*n,"");
            return res;
        }
        public void helper(int n,String sub){
            if(n==0){
                if(check(sub) && !set.contains(sub)){
                    set.add(sub);
                    res.add(sub);
                }
                sub="";
                return;
            }
            helper(n-1,sub+")");
            helper(n-1,sub+"(");
        }
    }
}
