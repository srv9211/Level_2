// https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/target-sum-subsets-dp-official/ojquestion

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = scn.nextInt();
        int tar = scn.nextInt();
        boolean[][] memo = new boolean[n+1][tar+1];
        // System.out.println(rec(arr, tar, n));
        System.out.println(dp(arr, tar, n, memo));
    }
    //recursion
    public static boolean rec(int[] arr, int tar, int n){
        
        if(tar==0) return true;
        else if(n==0) return false;
        
        boolean ans = false;
        if(tar >= arr[n-1]){
            ans = rec(arr, tar-arr[n-1], n-1);
        }
        ans = ans || rec(arr, tar, n-1);
        return ans;
    }
    //memo
    public static boolean memo(int[] arr, int tar, int n, boolean[][] memo){
        
        if(tar==0) return memo[n][tar] = true;
        else if(n==0) return false;
        
        if(memo[n][tar]) return true;
        
        boolean ans = false;
        if(tar >= arr[n-1]){
            ans = memo(arr, tar-arr[n-1], n-1, memo);
        }
        ans = ans || memo(arr, tar, n-1, memo);
        return memo[n][tar] = ans;
    }
    //dp
    public static boolean dp(int[] arr, int Tar, int N, boolean[][] dp){
        
        for(int n=0; n<=N; n++){
            for(int tar=0; tar<=Tar; tar++){
                if(tar==0){
                    dp[n][tar]=true;
                    continue;
                }
                else if(n==0) continue;
                
                boolean ans = false;
                if(tar >= arr[n-1]){
                    ans = dp[n-1][tar-arr[n-1]];//memo(arr, tar-arr[n-1], n-1, memo);
                }
                ans = ans || dp[n-1][tar];//memo(arr, tar, n-1, memo);
                dp[n][tar] = ans;
            }
        }
        return dp[N][Tar];
    }
    
}






