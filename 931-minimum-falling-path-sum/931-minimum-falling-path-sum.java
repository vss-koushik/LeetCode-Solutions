class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        int[] dp = new int[n];
        //for(int[] row : dp)
          //  Arrays.fill(row,-1);
        Arrays.fill(dp, -1);
        for(int i = 0; i < n; i++)
            dp[i] = matrix[n-1][i];
        for(int i = n - 2; i >= 0; i--){
            int diagLeft = Integer.MAX_VALUE;
            int down = diagLeft;
            int diagRight = diagLeft;
            int[] currRow = new int[n];
            for(int j = 0; j < n; j++){
                if(j > 0)
                    diagLeft = matrix[i][j] + dp[j - 1];
                down = matrix[i][j] + dp[j];
                if(j < n - 1)
                    diagRight = matrix[i][j] + dp[j + 1];
                
                currRow[j] = Math.min(diagLeft, Math.min(down, diagRight));
            }
            dp = currRow;
        }
        //int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++)
            min = Math.min(min, dp[i]);
        return min;
    }
    // Memoization Solution
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