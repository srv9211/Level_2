class Solution {
    public int fib(int n) {
        return dp(n);
        // int[] memo = new int[n+1];
        // return helper(n, memo);
        // return rec(n);
    }
    //recursion
    public int rec(int n){
        if(n==0) return 0;
        else if(n==1) return 1;
        return rec(n-1)+rec(n-2);
        
    }
    //memo
    public int helper(int n, int[] memo){
        if(n==1) return memo[n]=1;
        else if(n==0) return memo[n]=0;
        
        if(memo[n]!=0) return memo[n];
        
        return memo[n] = helper(n-1, memo)+helper(n-2, memo);
        
    }
    //dp
    public int dp(int n){
        int[] dp = new int[n+1];   
        for(int i=1; i<=n; i++){
            if(i==1){
                dp[i]=1;
                continue;
            }
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
