https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1#


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int cap, int wt[], int val[], int n){
       // Your code here
       int[][] memo = new int[n+1][cap+1];
       return dp(cap, wt, val, n, memo);
    } 
    //memo
    static int helper(int cap, int wt[], int val[], int n, int[][] memo){
        
       if(n==0 || cap==0) return 0;
       
       if(memo[n][cap] != 0) return memo[n][cap];
       
       int ans = 0;
       if(cap >= wt[n-1]){
            ans = helper(cap-wt[n-1], wt, val, n-1, memo);
            ans += val[n-1];
       }
        ans = Math.max(ans, helper(cap, wt, val, n-1, memo));
        
        return memo[n][cap] = ans;
        
    }
    //dp
    static int dp(int cap, int wt[], int val[], int n, int[][] dp){
        
        for(int i=0; i<=n; i++){
            for(int j=0; j<=cap; j++){
               if(i==0 || j==0){
                   dp[i][j]=0;
                   continue;
               }
               
               int ans = 0;
               if(j >= wt[i-1]){
                   ans = dp[i-1][j-wt[i-1]] + val[i-1];
               }
               
            dp[i][j] = Math.max(ans, dp[i-1][j] );
               
            }
        }
        return dp[n][cap];
    }
}
