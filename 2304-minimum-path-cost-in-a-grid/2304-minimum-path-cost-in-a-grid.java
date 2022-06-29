class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[m][n];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        for(int i = 0; i < n; i++)
            dp[m - 1][i] = grid[m-1][i];
        
        for(int i = m - 2; i >= 0; i--){
            for(int j = 0; j < n; j++){
                int val = grid[i][j];
                int mindp = Integer.MAX_VALUE;
                for(int ind = 0; ind < n; ind++){
                    mindp = Math.min(mindp, val + moveCost[val][ind] + dp[i + 1][ind]);
                }
                dp[i][j] = mindp;
            }
        }
        //int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++)
            min = Math.min(min, dp[0][i]);
        return min;
    }
    // Memoization
    private int helper(int i, int j, int[][] grid, int[][] moveCost, int n, int m, int[][] dp){
        if(i == m - 1)
            return grid[i][j];
        if(dp[i][j] != -1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        int val = grid[i][j];
        for(int ind = 0; ind < n; ind++){
            int sum = val + moveCost[val][ind] + helper(i + 1,ind, grid, moveCost, n,m,dp);
            min = Math.min(min, sum);    
        }
        
        return dp[i][j] = min;
    }
}