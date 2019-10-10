package Dynamic_Programming;

public class isSubsequence {
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
}
