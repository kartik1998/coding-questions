package Dynamic_Programming;

public class Largest_Sum_Of_Averages_Leetcode {
    public double largestSumOfAverages(int[] A, int K) {
        Double dp[][]=new Double[A.length+1][K+1];
        return helper(A,0,K,dp);
    }
    public double calculate(int A[],int l,int r){
        double sum=0;
        for(int i=l;i<=r;i++){
            sum+=A[i];
        }
        return sum/(r-l+1);
    }
    public double helper(int A[],int in,int k,Double dp[][]){
        if(in>=A.length){
            return 0;
        }
        if(k==1){
            return calculate(A,in,A.length-1);
        }
        if(dp[in][k]!=null){
            return dp[in][k];
        }
        double max = Integer.MIN_VALUE;
        for(int i=in;i<A.length;i++){
            double sub=calculate(A,in,i)+helper(A,i+1,k-1,dp);
            max=Math.max(max,sub);
        }
        return dp[in][k]=max;
    }
}
