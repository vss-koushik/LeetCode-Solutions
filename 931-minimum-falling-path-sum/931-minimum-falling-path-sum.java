class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        for(int i = 0; i < n; i++)
            min = Math.min(min,helper(0,i,matrix,n,dp));
        return min;
    }
    
    private int helper(int row, int col, int[][] grid, int n, int[][] dp){
        if(row == n - 1)
            return grid[row][col];
        if(dp[row][col] != -1) return dp[row][col];
        
        int diagLeft = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        int diagRight = Integer.MAX_VALUE;
        
        // going diagonal left
        if(col > 0)
            diagLeft = grid[row][col] + helper(row + 1, col - 1, grid, n, dp);
        
        // going direct down
        if(row < n - 1)
            down = grid[row][col] + helper(row + 1, col, grid, n,dp);
        
        // going diagonal right
        if(col < n - 1)
            diagRight = grid[row][col] + helper(row + 1, col + 1, grid, n, dp);
        
        return dp[row][col] = Math.min(diagLeft, Math.min(down, diagRight));
    }
}