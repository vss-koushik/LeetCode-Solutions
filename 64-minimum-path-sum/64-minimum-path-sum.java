class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        //System.out.println(m);
        int n = grid[0].length;
        //System.out.println(n);
        int[][] dp = new int[m][n];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return helper(0,0,m,n,grid, dp);
    }
    
    private int helper(int i, int j,int m, int n, int[][] grid,int[][] dp){
        if(i == m - 1 && j == n - 1) return grid[i][j];
        int right = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        if(dp[i][j] != -1) return dp[i][j];
        if(j < n - 1)
            right = grid[i][j] + helper(i, j + 1,m,n, grid, dp);
        if(i < m - 1)
            down = grid[i][j] + helper(i+1, j,m,n, grid, dp);
        
        return dp[i][j] = Math.min(right,down);
    }
}