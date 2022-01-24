class Solution {
    public int numDecodings(String s) {
        // int[] dp = new int[s.length()+1];
        int[] memo = new int[s.length()];
        return memo(s, 0, memo);
        // return dp(s, dp);

    }
    //memo
    public int memo(String s, int idx, int[] memo){
        if(idx>=s.length()) return 1;
        
        char ch = s.charAt(idx);
        int num = ch-'1'+1;
        if(num==0) return memo[idx]=0;
        
        if(memo[idx]!=0) return memo[idx];
        
        int ans = memo(s, idx+1, memo);
        
        if(idx != s.length()-1 && (num==1 || num==2) ){
            num = Integer.parseInt(s.substring(idx, idx+2));
            if(num<=26)
                ans += memo(s, idx+2, memo);
        }
        
        return memo[idx]=ans;
    }
    //dp
    public int dp(String s, int[] dp){
        dp[s.length()]=1;
        for(int idx=s.length()-1; idx>=0; idx--){
            char ch = s.charAt(idx);
            int num = ch-'1'+1;
            if(num==0){
                dp[idx]=0;
                continue;
            }
            
            int ans = dp[idx+1];//memo(s, idx+1, memo);
        
            if(idx != s.length()-1 && (num==1 || num==2) ){
                num = Integer.parseInt(s.substring(idx, idx+2));
                if(num<=26)
                    ans += dp[idx+2];//memo(s, idx+2, memo);
            }

            dp[idx]=ans;
        
        }
        return dp[0];
    }    
    
    
}
