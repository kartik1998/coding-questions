package Dynamic_Programming;
// Split a String in Balanced Strings My SubmissionsBack to Contest
//Balanced strings are those who have equal quantity of 'L' and 'R' characters.
////Given a balanced string s split it in the maximum amount of balanced strings.
//
//Return the maximum amount of splitted balanced strings.
//
//
//
//Example 1:
//
//Input: s = "RLRRLLRLRL"
//Output: 4
//Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
//Example 2:
//
//Input: s = "RLLLLRRRLR"
//Output: 3
//Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
//Example 3:
//
//Input: s = "LLLLRRRR"
//Output: 1
//Explanation: s can be split into "LLLLRRRR".
public class Split_Strings_Into_Balanced_Strings {
    public int balancedStringSplit(String S) {
        Integer dp[]=new Integer[S.length()+1];
        return helper(S,0,dp);
    }
    public boolean check(String S,int l,int r){
        int L=0;
        int R=0;
        for(int i=l;i<=r;i++){
            char ch=S.charAt(i);
            if(ch=='L'){
                L++;
            }else{
                R++;
            }
        }
        return R==L;
    }
    public int helper(String S,int in,Integer dp[]){
        if(in>=S.length()){
            return 0;
        }
        if(dp[in]!=null){
            return dp[in];
        }
        int max=0;
        for(int i=in;i<S.length();i++){
            if(check(S,in,i)){
                int sub=1+helper(S,i+1,dp);
                max=Math.max(max,sub);
            }
        }
        return dp[in]=max;
    }
}
