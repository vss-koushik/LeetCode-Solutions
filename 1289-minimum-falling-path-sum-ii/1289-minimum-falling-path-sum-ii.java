class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        if(n == 1) return grid[0][0];
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        for(int[] row : dp)
            Arrays.fill(row, - 1);
        for(int i = 0; i < n; i++)
            min = Math.min(min, helper(0,i,grid,n,dp));
        return min;
    }
    
    private int helper(int row, int col, int[][] grid, int n, int[][] dp){        
        if(row == n - 1)
            return grid[row][col];
        if(dp[row][col] != -1) return dp[row][col];
        int minLeft = Integer.MAX_VALUE;
        int minRight = Integer.MAX_VALUE;
        
        for(int i = 0; i <= col; i++){
            if(i == col + 1) continue;
            int ele = Integer.MAX_VALUE;
            if(i > 0)
                ele = grid[row][col] + helper(row + 1, i - 1, grid, n, dp);
            minLeft = Math.min(minLeft, ele);
        }
        
        for(int i = col; i < n ; i++){
                //ele = grid[row][i] + helper(row + 1, i - 1, grid, n, dp);
            int ele = 0;
            if(i == n - 1)
                ele = Integer.MAX_VALUE;
            else
                ele = grid[row][col] + helper(row + 1, i + 1, grid,n, dp);
            minRight = Math.min(minRight, ele);
        }
        
        return dp[row][col] = Math.min(minLeft, minRight);
    }
}