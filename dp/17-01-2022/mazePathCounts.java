import java.util.*;
public class countMazePath {
    public static void main(String[] args){
        int[][] dir = {{1,0},{0,1},{1,1}};
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(), m = scn.nextInt();
        int[][] memo = new int[n][m];
        dp_01(n, m, dir, memo);
        System.out.println(memo[0][0]);
    }
    //memoization
    public static int memo_01(int r, int c, int[][] dir, int[][] memo){
        if(r==0 && c==0) return memo[r][c]=1;
        if(memo[r][c] != 0) return memo[r][c];
        int count = 0;
        for(int[] d : dir){
            int x = r+d[0], y = c+d[1];
            if(x>=0 && y>=0)
                count += memo_01(x, y, dir, memo);
        }
        return memo[r][c] = count;
    }
    //dp
    public static int dp_01(int n, int m, int[][] dir, int[][] dp){
        int count = 0;
        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                if(j==m-1 && i==n-1){
                    dp[i][j]=1;
                    continue;
                }
                for(int[] d : dir){
                    int x = i+d[0], y = j+d[1];
                    if(x<n && y<m)
                        dp[i][j] += dp[x][y];
                }
            }
        }
        display(dp);
        return count;
    }
    // display
    public static void display(int[][] dp){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

}
