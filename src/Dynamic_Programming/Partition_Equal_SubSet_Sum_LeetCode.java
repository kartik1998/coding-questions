package Dynamic_Programming;

public class Partition_Equal_SubSet_Sum_LeetCode {
    public boolean canPartition(int[] A) {
        int sum=0;
        for(int i:A){
            sum+=i;
        }
        if(sum%2!=0){
            return false;
        }
        Boolean dp[][]=new Boolean[A.length+1][sum+1];
        return helper(A,A.length,sum/2,dp);
    }
    public boolean helper(int A[],int n,int sum,Boolean dp[][]){
        if(sum==0){
            return dp[n][sum]=true;
        }
        if(n==0 || sum<0){
            return false;
        }
        if(dp[n][sum]!=null){
            return dp[n][sum];
        }
        return dp[n][sum]=helper(A,n-1,sum-A[n-1],dp) || helper(A,n-1,sum,dp);
    }
}
