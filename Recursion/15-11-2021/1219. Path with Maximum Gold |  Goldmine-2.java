class Solution {
    public int gold(int[][] grid, int i, int j){
        if(i<0 || j<0 || i==grid.length || j==grid[0].length || grid[i][j]<=0){
            return 0;
        }
        int sum = 0;
        grid[i][j]=-grid[i][j];
        
        sum = Math.max(sum , gold(grid, i, j-1));
        sum = Math.max(sum, gold(grid, i, j+1));
        sum = Math.max(sum, gold(grid, i-1, j));
        sum = Math.max(sum, gold(grid, i+1, j));
        
        grid[i][j]=-grid[i][j];
        return sum+grid[i][j];
    }
    
    
    public int getMaximumGold(int[][] grid) {
        int max=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                max = Math.max(max,gold(grid, i, j));
            }
        }
        return max;
    }
}
