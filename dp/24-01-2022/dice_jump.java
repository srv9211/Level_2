import java.util.*;
public class dice_jump {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] memo = new int[n+1];
        // System.out.println(memo(0,n, memo));
        System.out.println(dp(0, n, memo));
        print1d(memo);
    }
    public static int memo(int sp, int ep, int[] memo){
        if(sp==ep) return memo[sp] = 1;

        if(memo[sp]!=0) return memo[sp];

        int count=0;
        for(int i=1; i<=6 && sp+i<=ep; i++){
            count += memo(sp+i, ep, memo);
        }
        return memo[sp] = count;

    }
    //dp
    public static int dp(int SP, int ep, int[] dp){
        for(int sp=ep; sp>=SP; sp--){
            if(sp==ep){
                dp[sp] = 1;
                continue;
            }
            int count=0;
            for(int i=1; i<=6 && sp+i<=ep; i++){
                count += dp[sp+i]; //memo(sp+i, ep, memo);
            }
            dp[sp] = count; //return memo[sp] = count;
        }
        return dp[0];
    }

    public static void print1d(int[] dp){
        for(int i=0; i<dp.length; i++)
            System.out.print(dp[i]+" ");
    }
}
